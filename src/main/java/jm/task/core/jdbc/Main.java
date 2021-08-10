package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.saveUser("Алексей", "Петров", (byte) 23);
        userService.saveUser("Петр", "Алексеев", (byte) 32);
        userService.saveUser("Лешка", "Петрович", (byte) 43);
        userService.removeUserById(1);
        userService.saveUser("Петька", "Алексеевич",(byte) 13);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
