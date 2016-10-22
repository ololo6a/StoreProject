package javacode.substance;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

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
    private String stringImage;

    private int vision;
    /*  1 = visible
    *   0 = invisible
    */
    public Product(){
        this.vision=1;
    }

    public int getVision() {
        return vision;
    }

    public void setVision(int vision) {
        this.vision = vision;
    }

    public Product(int id_product, Blob blob, String name, String type, int count, int id_master, double price) {
        this.id_product=id_product;
        this.blob = blob;
        this.name = name;
        this.type = type;
        this.count = count;
        this.id_master=id_master;
        this.price=price;
        this.vision=1;
    }

    public void setStringImagefromBlob(){
        if (blob==null) return ;

            byte [] imgData  = null;
            try {
                imgData = blob.getBytes(1, (int) blob.length());
            } catch (SQLException e) {
                e.printStackTrace();
            }


            String base64Encoded = null;
            if (imgData!=null) {
                byte[] decode = Base64.encodeBase64(imgData);
                try {
                    base64Encoded = new String(decode, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

        stringImage=base64Encoded;

    }

    public String getStringImage() {
        return stringImage;
    }

    public void setStringImage(String stringImage) {
        this.stringImage = stringImage;
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
