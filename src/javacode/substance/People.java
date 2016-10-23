package javacode.substance;

/**
 * Created by Администратор on 20.09.2016.
 */
public class People {

    private int id_people;
    private String type;
    private String passHash;
    private String email;
    private String addres;
    private String firstName;
    private String secondName;
    private double balance;
    private int buyOrders;
    private int sellOrders;



    public People(){};
    public People(int id,String type, String passHash, String email, String addres, String firstName, String secondName, double balance, int buyOrders, int sellOrders) {
        this.id_people=id;
        this.type = type;
        this.passHash = passHash;
        this.email = email;
        this.addres = addres;
        this.firstName = firstName;
        this.secondName = secondName;
        this.balance = balance;
        this.buyOrders = buyOrders;
        this.sellOrders = sellOrders;

    }


    public int getBuyOrders() {
        return buyOrders;
    }

    public void setBuyOrders(int buyOrders) {
        this.buyOrders = buyOrders;
    }

    public int getSellOrders() {
        return sellOrders;
    }

    public void setSellOrders(int sellOrders) {
        this.sellOrders = sellOrders;
    }
    public void addBalance(double balance){
        if (balance>0) this.balance+=balance;
    }
    public void decBalance(double balance){
        if (balance>0) this.balance-=balance;
    }

    public int getId_people() {
        return id_people;
    }

    public void setId_people(int id_people) {
        this.id_people = id_people;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
