package javacode.DAO;

import javacode.DAO.interfaces.MasterDao;
import javacode.substance.People;

import javax.servlet.http.Part;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

/**
 * Created by Администратор on 25.09.2016.
 */
public class OracleMasterDao extends OraclePeopleDao implements MasterDao {


    @Override
    public byte[] getImageByEmail(String email) {

        byte [] result = null;
        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet rs = statement.executeQuery(
                        "SELECT blob  FROM People where email = '" + email +"'")) {
                if (rs.next()) {
                    Blob blob = rs.getBlob("blob");
                    result = blob.getBytes(1, (int) blob.length());
                    return result;
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
}
