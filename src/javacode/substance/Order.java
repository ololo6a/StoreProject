/*
CREATE TABLE USER2."Order"
(
  id_order INT PRIMARY KEY NOT NULL,
  id_people INT NOT NULL,
  id_master INT NOT NULL,
  id_product INT NOT NULL,
  product_count INT NOT NULL,
  date_buy DATE NOT NULL,
  product_price REAL NOT NULL,
  CONSTRAINT Order_PEOPLE_ID_PEOPLE_fk FOREIGN KEY ( id_master) REFERENCES PEOPLE (ID_PEOPLE),
  CONSTRAINT Order_PEOPLE_fk FOREIGN KEY (id_people) REFERENCES PEOPLE (ID_PEOPLE),
  CONSTRAINT Order_PRODUCTS_ID_PRODUCT_fk FOREIGN KEY (id_product) REFERENCES PRODUCTS (ID_PRODUCT)
);
CREATE UNIQUE INDEX "Order_id_order_uindex" ON USER2."Order" (id_order);
 */

package javacode.substance;



/**
 * Created by Администратор on 21.09.2016.
 */
public class Order {

    private int id_order;
    private int id_master;
    private int id_people;
    private int id_product;
    private double price;
    private int count;
    private String date;
    private String addres;

    private String name;
    private String surname;

    public Order(){}

    public Order(int id_order, int id_master, int id_people, int id_product, double price, int count, String date,
                 String addres, String name, String surname) {
        this.id_order = id_order;
        this.id_master = id_master;
        this.id_people = id_people;
        this.id_product = id_product;
        this.price = price;
        this.count = count;
        this.date = date;
        this.addres = addres;
        this.name = name;
        this.surname = surname;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public int getId_master() {
        return id_master;
    }

    public void setId_master(int id_master) {
        this.id_master = id_master;
    }

    public int getId_people() {
        return id_people;
    }

    public void setId_people(int id_people) {
        this.id_people = id_people;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}