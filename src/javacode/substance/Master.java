package javacode.substance;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * Created by Администратор on 21.09.2016.
 */
public class Master extends People {
    private Blob faceImage;
    private String stringImage;

    public Master(){
        super();
    };
    public Master(int id, String type, String passHash, String email, String addres, String firstName, String secondName, double balance, Blob faceImage, int buyOrders, int sellOrders) {
        super(id, type, passHash, email, addres, firstName, secondName, balance,buyOrders,sellOrders);
        this.faceImage = faceImage;
    }

    public Blob getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(Blob faceImage) {
        this.faceImage = faceImage;
    }

    public void setStringImage(String t){
        this.stringImage=t;
    }
    public String getStringImage(){
        return stringImage;
    }

    public void setStringImagefromBlob(){
        if (faceImage==null) return ;

        byte [] imgData  = null;
        try {
            imgData = faceImage.getBytes(1, (int) faceImage.length());
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
}
