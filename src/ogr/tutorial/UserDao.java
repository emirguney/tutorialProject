package ogr.tutorial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ME99735 on 27.07.2018 - 12:22
 * part of project: tutorialProject
 */

public class UserDao {

    Connection c = Constants.getConnection();

    public void save(User user) {
        try {
            Statement stm = c.createStatement();

            String query = "insert into T_USERS(username, password, email) values ('" + user.getUsername() + "', '" + user.getPassword() + "', '" + user.getEmail() + "')";

            stm.executeUpdate(query);
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll() {
        try {
            Statement stm = c.createStatement();
            ResultSet resultSet = stm.executeQuery("select * from T_USERS");
            List<User> users = new ArrayList<User>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                User user = new User();
                user.setId(id);
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                users.add(user);
            }
            resultSet.close();
            stm.close();
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(User user) {
        try {
            Statement stm = c.createStatement();

            String query = "update T_USERS set username = '" + user.getUsername() + "', password = '" + user.getPassword() + "', email = '" + user.getEmail() + "' where id = " + user.getId();

            stm.executeUpdate(query);
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int deleteId) {
        try {
            Statement stm = c.createStatement();
            String query = "delete from T_USERS where id=" + deleteId;
            stm.executeUpdate(query);
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
