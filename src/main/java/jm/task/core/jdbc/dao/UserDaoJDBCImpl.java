package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String table = "CREATE TABLE IF NOT EXISTS newUsers (id int NOT NULL AUTO_INCREMENT, name varchar (40), lastName varchar(255) NOT NULL, age (255), PRIMARY KEY (ID))";
        try (Statement statement = connection.createStatement()) {
            statement.execute(table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String table = "DROP TABLE IF EXISTS newUsers";
        try (Statement statement = connection.createStatement()) {
            statement.execute(table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String users = "INSERT INTO newUsers (name, lastName, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(users)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.printf("User с именем – %s добавлен в базу данных\n", name);
        } catch (SQLException e) {
            System.out.printf("Не удалось добавить в базу User с именем – %s\n", name);
        }
    }

    public void removeUserById(long id) {
        String table = "DELETE FROM newUsers WHERE id=?";
        User user = new User();
        try (PreparedStatement preparedStatement = connection.prepareStatement(table)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String table = "SELECT id, name, lastName, age FROM newUsers";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(table);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge((byte) resultSet.getLong("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(users);
        return users;
    }

    public void cleanUsersTable() {
        String table = "TRUNCATE TABLE newUsers";
        try (Statement statement = connection.createStatement()) {
            statement.execute(table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
