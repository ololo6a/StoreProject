package javacode.DAO;

import javacode.DAO.interfaces.BeMasterDao;
import javacode.substance.BeMaster;
import javacode.substance.People;
import sun.awt.image.ImageWatched;

import java.sql.*;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
/**
 * Created by Администратор on 28.09.2016.
 */
public class OracleBeMasterDao implements BeMasterDao{

    private static final Logger logger = Logger.getLogger(OracleBeMasterDao.class);

    @Override
    public List<People> getAll(){
        LinkedList<People> all = new LinkedList<People>();

        try(final Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery
                    ("select * from  PEOPLE where id_people in (select id_people from BEMASTER) ")){
            while (rs.next()){

                    all.add( new People(rs.getInt("id_people"),
                            rs.getString("STYPE"),
                            rs.getString("passhash"),
                            rs.getString("email"),
                            rs.getString("addres"),
                            rs.getString("firstname"),
                            rs.getString("lastname"),
                            rs.getDouble("balance"),
                            rs.getInt("buyorders"),
                            rs.getInt("sellorders")
                    ));
            }

        } catch (SQLException e) {
            logger.error("SQLException getAll", e);
        }



        return all;
    }

    @Override
    public boolean insert(BeMaster beMaster) {

        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery
                    ("insert into BEMASTER(ID_PEOPLE,TEXT) " +
                            "VALUES ( " + beMaster.getId_people() +"," +
                                      "'" + beMaster.getText() + "')"))
        {

        } catch (SQLException e) {
            logger.error("SQLException insert", e);
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteByEmail(String email) {

        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery
                    ("delete from BEMASTER where ID_PEOPLE in (select id_people from PEOPLE where email = '" + email+ "')"))
        {

        } catch (SQLException e) {
            logger.error("SQLException deleteByEmail", e);
            return false;
        }

        return true;
    }
}
