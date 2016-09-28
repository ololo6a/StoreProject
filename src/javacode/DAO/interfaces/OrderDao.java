package javacode.DAO.interfaces;

import javacode.substance.Order;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Администратор on 28.09.2016.
 */
public interface OrderDao    {
    List<Order> getById(int id_people);
}
