package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SharedSessionContract;
import org.hibernate.Transaction;
import org.hibernate.sql.ordering.antlr.Factory;

import javax.management.Query;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
 Util util = new Util();

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        try {
            Session session = util.connect().openSession();
            Transaction tr = session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS newuser(id int NOT NULL AUTO_INCREMENT, name varchar (40), lastName varchar(40), age varchar(255), PRIMARY KEY (id))")
                    .executeUpdate();
            tr.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            Session session = util.connect().openSession();
            Transaction tr = session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS newuser").executeUpdate();
            tr.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            Session session = util.connect().openSession();
            User user = new User();
            user.setAge(age);
            user.setLastName(lastName);
            user.setName(name);
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
            System.out.printf("User с именем – %s добавлен в базу данных\n", name);
        } catch (Exception e) {
            System.out.printf("Не удалось добавить в базу User с именем – %s\n", name);
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = util.connect().openSession();
            Transaction transaction = session.beginTransaction();
            session.createQuery("delete from User where id =" + id).executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> user = new ArrayList<>();
        try {
            Session session = util.connect().openSession();
            Transaction transaction = session.beginTransaction();
            user = session.createQuery("from User").list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = util.connect().openSession();
            Transaction transaction = session.beginTransaction();
            session.createQuery("delete from User").executeUpdate();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
