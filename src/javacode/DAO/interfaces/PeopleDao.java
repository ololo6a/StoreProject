package javacode.DAO.interfaces;

import javacode.substance.People;

import java.sql.Blob;
import java.util.List;

/**
 * Created by Администратор on 22.09.2016.
 */
public interface PeopleDao {

    List<? extends People> getAll();
    boolean insertPeople(People people);
    int findPeople(People people);
    boolean updatePeopleByEmail(String email, People people);
    People getPeopleByEmail(String email);


}
