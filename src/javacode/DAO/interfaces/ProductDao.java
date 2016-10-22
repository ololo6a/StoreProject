package javacode.DAO.interfaces;

import javacode.substance.Master;
import javacode.substance.Product;

import javax.servlet.http.Part;
import java.util.LinkedList;

/**
 * Created by Администратор on 28.09.2016.
 */
public interface ProductDao {
    boolean addThing(Product product,Part blob);
    /*
      set blob = null if you dont hava image
     */

    Product getById(int id);
    boolean changeCount(int id, int count);
    Master getAuthor(int product);
    boolean setInvisibleOrDeleteById(int idproduct);

    LinkedList<Product> getAll(int onlyvisible);
    /* set onlyvisible = 1 for only visible things
       2 = all things
       0 = only invisible
     */

    LinkedList<Product> getAllWithType(int onlyvisible,String stype);

    LinkedList<Product> getMy(int id_people);

    boolean change(int id, Product p, Part blob);


}
