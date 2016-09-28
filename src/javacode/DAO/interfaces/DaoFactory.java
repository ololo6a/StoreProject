package javacode.DAO.interfaces;

import javacode.substance.Order;

/**
 * Created by Администратор on 22.09.2016.
 */
public interface DaoFactory {
    PeopleDao getPeopleDao();
    MasterDao getMasterDao();
    BeMasterDao getBeMasterDao();
    OrderDao getOrderDao();
    ProductDao getProductDao();

}

