package javacode.DAO;

import javacode.DAO.interfaces.MasterDao;
import javacode.substance.Master;
import javacode.substance.People;

import javax.servlet.http.Part;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Администратор on 25.09.2016.
 */
public class OracleMasterDao extends OraclePeopleDao implements MasterDao {

    @Override
    public List<? extends People> getAll(){

        List<Master> all = new LinkedList<Master>();
        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT *  FROM People where stype <> 'user'")) {
            while (rs.next()) {
                Master m = new Master();
                m.setEmail(rs.getString("email"));
                m.setAddres(rs.getString("addres"));
                m.setFirstName(rs.getString("firstname"));
                m.setSecondName(rs.getString("lastname"));
                m.setBalance(rs.getDouble("balance"));
                m.setPassHash(rs.getString("passhash"));
                m.setId_people(rs.getInt("id_people"));
                m.setBuyOrders(rs.getInt("buyorders"));
                m.setSellOrders(rs.getInt("sellorders"));
                m.setType(rs.getString("stype"));
                all.add(m);
            }

        } catch (SQLException e) {
            //  logger.error("SQLException in getting Reader by email",e);
            return all;
        }

        return all;
    }
    @Override
    public byte[] getImageByEmail(String email) {

        byte [] result = null;
        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet rs = statement.executeQuery(
                        "SELECT blob  FROM People where email = '" + email +"'")) {
                if (rs.next()) {
                    Blob blob = rs.getBlob("blob");
                   if (blob!=null)  result = blob.getBytes(1, (int) blob.length());
                    return result;
                }

            } catch (SQLException e) {
                //  logger.error("SQLException in getting Reader by email",e);
            }
            return null;
        }

    @Override
    public Blob getBlob(String email) {
        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT blob  FROM People where email = '" + email +"'")) {
            if (rs.next()) {
                Blob blob = rs.getBlob("blob");
                return blob;
            }

        } catch (SQLException e) {
            //  logger.error("SQLException in getting Reader by email",e);
        }
        return null;
    }

    @Override
    public boolean insertImageByEmail(String email, Part blob) {
        try{
            final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
                      InputStream fin = blob.getInputStream();
            PreparedStatement pre = connection.prepareStatement("update people set blob = ? where email ='" + email+ "'");
            pre.setBinaryStream(1,fin,(int)blob.getSize());
            pre.executeUpdate();


        } catch (SQLException e) {
            //  logger.error("SQLException in getting Reader by email",e);1
            return false;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Master getPeopleById(int id) {

        try (final Connection connection = OracleDaoFactory.getConnection();
             final Statement statement = connection.createStatement();
             final ResultSet rs = statement.executeQuery(
                     "SELECT id_people, stype, passhash, email, addres, firstname, lastname, balance, buyorders, sellorders FROM People where id_people = " + id)) {
            if (rs.next()) {
                return new Master(rs.getInt("id_people"),
                        rs.getString("STYPE"),
                        rs.getString("passhash"),
                        rs.getString("email"),
                        rs.getString("addres"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getDouble("balance"),
                        null,
                        rs.getInt("buyorders"),
                        rs.getInt("sellorders")
                );

            }

        } catch (SQLException e) {
            //  logger.error("SQLException in getting Reader by email",e);
        }
        return null;
    }
}
