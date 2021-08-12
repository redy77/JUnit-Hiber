//package jm.task.core.jdbc.util;
//
//import jm.task.core.jdbc.model.User;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//
//import java.util.Properties;
//
//public class UtilHibernate {
//    private static SessionFactory sessionFactory;
//    public  Session connect() {
//        Session session = null;
//        if (session == null) {
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
//}
