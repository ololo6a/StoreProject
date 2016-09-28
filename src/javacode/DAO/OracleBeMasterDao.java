package javacode.DAO;

import javacode.DAO.interfaces.BeMasterDao;
import javacode.substance.BeMaster;

import java.sql.*;
import java.util.List;

/**
 * Created by Администратор on 28.09.2016.
 */
public class OracleBeMasterDao implements BeMasterDao{
    @Override
    public List<BeMaster> getAll() {
        return null;
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

            return false;
        }

        return true;
    }

    @Override
    public boolean remove(BeMaster beMaster) {

        try(final java.sql.Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery
                    ("delete from BEMASTER where id = " + beMaster.getId()))
        {

        } catch (SQLException e) {

            return false;
        }

        return true;
    }
}
