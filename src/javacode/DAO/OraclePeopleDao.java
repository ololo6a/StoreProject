package javacode.DAO;

import javacode.DAO.interfaces.PeopleDao;
import javacode.substance.People;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


/**
 * Created by Администратор on 22.09.2016.
 */
public class OraclePeopleDao implements PeopleDao {

    private static final Logger logger = Logger.getLogger(PeopleDao.class);

    @Override
    public List<? extends  People> getAll() {
        return null;
    }



    @Override
    public boolean insertPeople(People people) {


        try(final Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery
                    ("insert into PEOPLE(stype,passhash,email,addres,firstname, lastname, balance) " +
                            "VALUES ( '" + people.getType() + "'," +
                               "'" + people.getPassHash() + "'," +
                               "'" + people.getEmail() + "'," +
                               "'" + people.getAddres() + "'," +
                               "'" + people.getFirstName() + "'," +
                               "'" + people.getSecondName() + "'," +
                                + people.getBalance()+ ")"))
        {

        } catch (SQLException e) {
            logger.error("SQLException insertPeople", e);
            return false;
        }

        return true;
        }

    @Override
    public int findPeople(People people) {
        return 0;
    }

    @Override
    public boolean updatePeopleByEmail(String email, People people) {

        String query = " UPDATE  PEOPLE set " +
                "stype = '" + people.getType()+ "'," +
                "passhash= '" + people.getPassHash() + "'," +
                "email= '" + people.getEmail() + "'," +
                "addres= '" + people.getAddres() + "'," +
                "FIRSTname= '" + people.getFirstName() + "'," +
                "lastname= '" + people.getSecondName() + "'," +
                "balance= " + people.getBalance() + "," +
                "buyorders= " + people.getBuyOrders() + "," +
                "sellorders= " + people.getSellOrders() + " " +
                "where email ='" + email + "'";

        if (people.getPassHash().equals("")) {
            query = " UPDATE  PEOPLE set " +
                    "stype = '" + people.getType()+ "'," +
                    "email= '" + people.getEmail() + "'," +
                    "addres= '" + people.getAddres() + "'," +
                    "FIRSTname= '" + people.getFirstName() + "'," +
                    "lastname= '" + people.getSecondName() + "'," +
                    "balance= " + people.getBalance() + "," +
                    "buyorders= " + people.getBuyOrders() + "," +
                    "sellorders= " + people.getSellOrders() + " " +
                    "where email ='" + email + "'";
        }

        try(final Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(query)){


        } catch (SQLException e) {
            logger.error("SQLException updatePeopleByEmail", e);
            return false;
        }
        return true;
    }

    @Override
    public People getPeopleByEmail(String email) {

        try(final Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT id_people, stype, passhash, email, addres, firstname, lastname, balance, buyorders, sellorders FROM People where email = '" + email +"'")) {
            if (rs.next()) {

                return new People(rs.getInt("id_people"),
                        rs.getString("STYPE"),
                        rs.getString("passhash"),
                        rs.getString("email"),
                        rs.getString("addres"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getDouble("balance"),
                        rs.getInt("buyorders"),
                        rs.getInt("sellorders")
                    );

            }

        } catch (SQLException e) {
            logger.error("SQLException getPeopleByEmail", e);
        }
        return null;
    }

    @Override
    public boolean addBalance(People people, double balance) {
        try(final Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery("UPDATE PEOPLE SET BALANCE = BALANCE + "+balance+ " where email = '" + people.getEmail()+ "'")) {

        } catch (SQLException e) {
            logger.error("SQLException addBalance", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean addSellOrder(int id) {
        String s = "UPDATE PEOPLE SET sellorders = sellorders+1 where id_people ="+ id;
        try(final Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery("UPDATE PEOPLE SET sellorders = sellorders+1 where id_people ="+ id)) {

        } catch (SQLException e) {
            logger.error("SQLException addSellOrder", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean addBuyOrder(int id) {
        try(final Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery("UPDATE PEOPLE SET buyorders = buyorders+1 where id_people ="+ id)) {

        } catch (SQLException e) {
            logger.error("SQLException addBuyOrder", e);
            return false;
        }
        return true;
    }


}
