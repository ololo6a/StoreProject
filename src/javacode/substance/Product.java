package javacode.substance;

import java.sql.Blob;

/**
 * Created by Администратор on 21.09.2016.
 */

public class Product {

    private int id_product;
    private Blob blob;
    private String name;
    private String type;
    private int count;
    private int id_master;
    private double price;
    public Product(int id_product, Blob blob, String name, String type, int count, int id_master, double price) {
        this.id_product=id_product;
        this.blob = blob;
        this.name = name;
        this.type = type;
        this.count = count;
        this.id_master=id_master;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId_master() {
        return id_master;
    }

    public void setId_master(int id_master) {
        this.id_master = id_master;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public Blob getBlob() {
        return blob;
    }

    public void setBlob(Blob blob) {
        this.blob = blob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
