package jm.task.core.jdbc.util;


import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/taskjdbc?";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root-123";
    private static Connection connection;
//    private static SessionFactory sessionFactory;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
        }
        return connection;
    }

//    public static Session connect() {
//        Session session = null;
//        if (sessionFactory == null) {
//            try {
//                Properties prop = new Properties();
//                prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/taskjdbc");
//                prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
//                prop.setProperty("hibernate.connection.username", "root");
//                prop.setProperty("hibernate.connection.password", "root-123");
//                sessionFactory = new Configuration().addProperties(prop).addPackage("jm.task.core.jdbc").addAnnotatedClass(User.class).buildSessionFactory();
//                session = sessionFactory.openSession();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return session;
//    }
}
