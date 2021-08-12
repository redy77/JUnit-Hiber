package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.UtilHibernate;

public class Main {
    public static void main(String[] args) {
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
//      userDaoHibernate.dropUsersTable();
//        userDaoHibernate.createUsersTable();
//        userDaoHibernate.cleanUsersTable();
        userDaoHibernate.saveUser("kjsh", "jhfd", (byte) 5);
        userDaoHibernate.saveUser("kjsh", "jhfd", (byte) 8);
//        userDaoHibernate.removeUserById(2);
        System.out.println(userDaoHibernate.getAllUsers());


//        UserService userService = new UserServiceImpl();
//        userService.createUsersTable();
//        userService.saveUser("Алексей", "Петров", (byte) 23);
//        userService.saveUser("Петр", "Алексеев", (byte) 32);
//        userService.saveUser("Лешка", "Петрович", (byte) 43);
//        userService.removeUserById(1);
//        userService.saveUser("Петька", "Алексеевич",(byte) 13);
//        userService.getAllUsers();
//        userService.cleanUsersTable();
//        userService.dropUsersTable();

    }
}
