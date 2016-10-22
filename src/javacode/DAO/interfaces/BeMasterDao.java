package javacode.DAO.interfaces;

import javacode.substance.BeMaster;
import javacode.substance.People;

import javax.servlet.http.Part;
import java.sql.Blob;
import java.util.List;

/**
 * Created by Администратор on 25.09.2016.
 */
public interface BeMasterDao {

    List<People> getAll();
    boolean insert(BeMaster beMaster);
    boolean deleteByEmail(String email);

}
