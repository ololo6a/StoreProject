package javacode.DAO;

import javacode.DAO.interfaces.ProductDao;
import javacode.substance.Master;
import javacode.substance.People;
import javacode.substance.Product;

import javax.naming.ldap.PagedResultsControl;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Администратор on 28.09.2016.
 */
public class OracleProductDao implements ProductDao {
    @Override
    public boolean addThing(Product product,Part blob) {

        String query = "insert into products (name,ptype,count,price,id_master,image)" +
                "values ('" + product.getName() +"'," +
                " '" + product.getType() +"'," +
                " " + product.getCount() + "," +
                " " + product.getPrice() + "," +
                " " + product.getId_master()+ ", ? ) ";


        try {
            final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final PreparedStatement pre = connection.prepareStatement(query);
            InputStream fin = blob.getInputStream();
            pre.setBinaryStream(1, fin, (int) blob.getSize());
            pre.execute();

        }
         catch (IOException e) {
            e.printStackTrace();
                return false;
        }

         catch (SQLException e) {
            //  logger.error("SQLException in getting Reader by email",e);1
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Product getById(int id) {
        Product p = null;
        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "select * from PRODUCTS where id_product ="+id)) {
            if (rs.next()){
                p = new Product();
                p.setBlob(rs.getBlob("image"));
                p.setName(rs.getString("name"));
                p.setType(rs.getString("ptype"));
                p.setCount(rs.getInt("count"));
                p.setPrice(rs.getDouble("PRICE"));
                p.setId_master(rs.getInt("id_master"));
                p.setId_product(rs.getInt("id_product"));
                p.setStringImagefromBlob();
            }
        } catch (SQLException e) {
            //  logger.error("SQLException in getting Reader by email",e);
            return null;
        }
        return p;
    }


    @Override
    public boolean changeCount(int id, int count) {
        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final  ResultSet rs2 = statement.executeQuery(
                    "UPDATE PRODUCTS set count = count +"+count+" where id_product ="+id + " and ((count+ "+count+")>-1)")){
            } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Master getAuthor(int product) {

        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT id_master  FROM PRODUCTS where id_product =" + product)) {
            if (rs.next()){
                int a = rs.getInt("id_master");
                final ResultSet  rss = statement.executeQuery("select * from people where id_people="+a);
                if (rss.next()) {
                    return new Master(rss.getInt("id_people"),
                            rss.getString("STYPE"),
                            rss.getString("passhash"),
                            rss.getString("email"),
                            rss.getString("addres"),
                            rss.getString("firstname"),
                            rss.getString("lastname"),
                            rss.getDouble("balance"),
                            rss.getBlob("blob"),
                            rss.getInt("buyorders"),
                            rss.getInt("sellorders")
                            );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //  logger.error("SQLException in getting Reader by email",e);
            return null;
        }
        return null;
    }

    @Override
    public boolean setInvisibleOrDeleteById(int idproduct) {

        boolean haveorder = true;
        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT count(*)  FROM \"Order\" where id_product =" + idproduct)) {
            if (rs.next()) {
                if (rs.getInt(1) == 0) haveorder = false;
            }
        } catch (SQLException e) {
            //  logger.error("SQLException in getting Reader by email",e);
            return false;
        }
        if (haveorder==false) {
            try (final java.sql.Connection connection = OracleDaoFactory.getConnection();
                 final Statement statement = connection.createStatement();
                 final ResultSet rs = statement.executeQuery(
                         "delete  from products where id_product="+idproduct)){

            } catch (SQLException e) {
                //  logger.error("SQLException in getting Reader by email",e);
                return false;
            }
        }


        if (haveorder==true) {
            try (final java.sql.Connection connection = OracleDaoFactory.getConnection();
                 final Statement statement = connection.createStatement();
                 final ResultSet rs = statement.executeQuery(
                         "update products set vision=0 where id_product ="+idproduct)){

            } catch (SQLException e) {
                //  logger.error("SQLException in getting Reader by email",e);
                return false;
            }
        }
        return true;
    }


    @Override
    public LinkedList<Product> getAll(int onlyvisible) {
        return null;
    }

    @Override
    public LinkedList<Product> getAllWithType(int onlyvisible, String stype) {
        LinkedList<Product> all = new  LinkedList<Product>();

        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT *  FROM PRODUCTS where ptype ='" +stype+ "' and vision="+onlyvisible)) {
            while (rs.next()) {
                Product p = new Product();
                p.setBlob(rs.getBlob("image"));
                p.setName(rs.getString("name"));
                p.setType(rs.getString("ptype"));
                p.setCount(rs.getInt("count"));
                p.setPrice(rs.getDouble("PRICE"));
                p.setId_master(rs.getInt("id_master"));
                p.setId_product(rs.getInt("id_product"));
                p.setStringImagefromBlob();
                all.add(p);
            }

        } catch (SQLException e) {
            //  logger.error("SQLException in getting Reader by email",e);
            return all;
        }

        return all;
    }

    @Override
    public LinkedList<Product> getMy(int id_people) {
        LinkedList<Product> allmy = new  LinkedList<Product>();

        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT *  FROM PRODUCTS where id_master =" + id_people+ " and vision=1")) {
            while (rs.next()) {
                Product p = new Product();
                p.setBlob(rs.getBlob("image"));
                p.setName(rs.getString("name"));
                p.setType(rs.getString("ptype"));
                p.setCount(rs.getInt("count"));
                p.setPrice(rs.getDouble("PRICE"));
                p.setId_master(id_people);
                p.setId_product(rs.getInt("id_product"));
                p.setStringImagefromBlob();
                allmy.add(p);
            }

        } catch (SQLException e) {
            //  logger.error("SQLException in getting Reader by email",e);
            return allmy;
        }

        return allmy;
    }



    @Override
    public boolean change(int id, Product p, Part blob) {
         if (blob!=null) {
             try {
                 final java.sql.Connection connection = OracleDaoFactory.getConnection();
                 final Statement statement = connection.createStatement();
                 InputStream fin = blob.getInputStream();
                 PreparedStatement pre = connection.prepareStatement("update products set image = ? where id_product =" + id);
                 pre.setBinaryStream(1, fin, (int) blob.getSize());
                 pre.executeUpdate();


             } catch (SQLException e) {
                 e.printStackTrace();
                 return false;
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }

         if (p!=null){
             try (final java.sql.Connection connection = OracleDaoFactory.getConnection();
                  final Statement statement = connection.createStatement();
                  final ResultSet rs = statement.executeQuery(
                          "update products set" +
                                  " vision="+p.getVision() +", " +
                                  " name='"+p.getName() +"', " +
                                  " ptype='"+p.getType() +"', " +
                                  " count="+p.getCount() +", " +
                                  " price="+p.getPrice() +" " +
                                  " where id_product ="+id)){

             } catch (SQLException e) {
                 e.printStackTrace();
                 return false;
             }
         }
        return true;
    }
}
