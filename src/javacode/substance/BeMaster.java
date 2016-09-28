package javacode.substance;

/**
 * Created by Администратор on 27.09.2016.
 */
public class BeMaster {
    private int id;
    private int id_people;
    private String text;

    public BeMaster(int id, int id_people, String text) {
        this.id = id;
        this.id_people = id_people;
        this.text = text;
    }
    public BeMaster(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_people() {
        return id_people;
    }

    public void setId_people(int id_people) {
        this.id_people = id_people;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
