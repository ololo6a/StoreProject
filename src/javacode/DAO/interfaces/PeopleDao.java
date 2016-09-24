package javacode.DAO.interfaces;

import javacode.substance.People;

import java.util.List;

/**
 * Created by Администратор on 22.09.2016.
 */
public interface PeopleDao {

    List<People> getAll();
    boolean insertPeople(People people);
    int findPeople(People people);

    People getPeopleByEmail(String email);


}
