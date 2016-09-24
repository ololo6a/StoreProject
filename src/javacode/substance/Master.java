package javacode.substance;

import java.sql.Blob;

/**
 * Created by Администратор on 21.09.2016.
 */
public class Master extends People {
    private Blob faceImage;

    public Master(int id, String type, String passHash, String email, String addres, String firstName, String secondName, double balance, Blob faceImage) {
        super(id, type, passHash, email, addres, firstName, secondName, balance);
        this.faceImage = faceImage;
    }

    public Blob getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(Blob faceImage) {
        this.faceImage = faceImage;
    }
}
