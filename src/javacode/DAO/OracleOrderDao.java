package javacode.DAO;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.operations.Or;
import javacode.DAO.interfaces.OrderDao;
import javacode.substance.Order;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Администратор on 28.09.2016.
 */
public class OracleOrderDao implements OrderDao {

    private static final Logger logger = Logger.getLogger(OracleOrderDao.class);

    @Override
    public List<Order> getById(int id_people) {

        LinkedList<Order>  result = new LinkedList<Order>();
        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT * FROM \"Order\" where id_people =" + id_people +" or id_master = " + id_people + "ORDER BY id_order" )) {


            while (rs.next()) {
                Order one = new Order(rs.getInt("id_order"),
                        rs.getInt("id_master"),
                        rs.getInt("id_people"),
                        rs.getInt("id_product"),
                        rs.getDouble("product_price"),
                        rs.getInt("product_count"),
                        rs.getDate("date_buy").toString(),
                        rs.getString("addres"),
                        rs.getString("name"),
                        rs.getString("surname")
                );

                result.add(one);

            }

        } catch (SQLException e) {
            logger.error("SQLException getById", e);
            return result;
        }
       return result;
    }

    @Override
    public boolean NewOrder(int buyer, int saler, int product, int count, double price, String date, String addres, String name, String surname) {
       String s  ="insert into \"Order\" (id_people,id_master,id_product,product_count,date_buy,product_price,addres,name,surname) " +
                           "VALUES (" +buyer+","+saler +", " + product+", "+ count+",  TO_DATE('"+date+"','yyyy-mm-dd'), " +
               price+", '"+addres+"','" + name  + "','"+ surname+"')";


        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(s)) {
        } catch (SQLException e) {
            //  logger.error("SQLException in getting Reader by email",e);
            logger.error("SQLException NewOrder", e);
            return false;
        }
        return true;
    }
}
