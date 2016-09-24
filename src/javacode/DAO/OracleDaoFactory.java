package javacode.DAO;

import javacode.DAO.interfaces.DaoFactory;
import javacode.DAO.interfaces.PeopleDao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by Администратор on 22.09.2016.
 */
public class OracleDaoFactory implements DaoFactory {


    final private static String driverName = "oracle.jdbc.driver.OracleDriver";
    final private static String username = "user2";
    final private static String password = "user2";
    final private static String url= "jdbc:oracle:thin:@localhost:1521:XE";

    /**
     * Return connection by params
     * @return Connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName(driverName).newInstance();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
           //  logger.error("Exception in getConnection",e);
            e.printStackTrace();
        }
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    @Override
    public PeopleDao getPeopleDao() {
        return new OraclePeopleDao();
    }
}
