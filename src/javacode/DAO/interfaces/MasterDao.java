package javacode.DAO.interfaces;

import javacode.substance.Master;

import javax.servlet.http.Part;
import java.sql.Blob;

/**
 * Created by Администратор on 25.09.2016.
 */
public interface MasterDao extends PeopleDao {

     byte[]  getImageByEmail(String email);
     Blob getBlob(String email);
     boolean insertImageByEmail(String email, Part blob);

    Master getPeopleById(int id);
}
