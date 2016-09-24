package javacode.DAO;

import javacode.DAO.interfaces.DaoFactory;

/**
 * Created by Администратор on 22.09.2016.
 */
public class Connection {
    private static DaoFactory factory = null;

    /**
     * Returns DAOFactory
     * @return {@link OracleDaoFactory}
     */
    public static DaoFactory getFactory() {
        if (factory == null) {
            factory = new OracleDaoFactory();
        }
        return factory;
    }
}