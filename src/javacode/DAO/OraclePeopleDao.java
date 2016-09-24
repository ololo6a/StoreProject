package javacode.DAO;

import javacode.DAO.interfaces.PeopleDao;
import javacode.substance.People;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Администратор on 22.09.2016.
 */
public class OraclePeopleDao implements PeopleDao {

    @Override
    public List<People> getAll() {
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

            return false;
        }

        return true;
        }

    @Override
    public int findPeople(People people) {
        return 0;
    }

    @Override
    public People getPeopleByEmail(String email) {


        try(final Connection connection = OracleDaoFactory.getConnection();
            final Statement statement = connection.createStatement();
            final ResultSet rs = statement.executeQuery(
                    "SELECT id_people, stype, passhash, email, addres, firstname, lastname, balance FROM People where email = '" + email +"'")) {


            if (rs.next()) {

                return new People(rs.getInt("id_people"),
                        rs.getString("STYPE"),
                        rs.getString("passhash"),
                        rs.getString("email"),
                        rs.getString("addres"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getDouble("balance"));

            }

        } catch (SQLException e) {
          //  logger.error("SQLException in getting Reader by email",e);
        }
        return null;
    }


}
