package javacode.DAO.interfaces;

import javax.servlet.http.Part;
import java.sql.Blob;

/**
 * Created by Администратор on 25.09.2016.
 */
public interface MasterDao extends PeopleDao {

     byte[]  getImageByEmail(String email);
     boolean insertImageByEmail(String email, Part blob);
}
