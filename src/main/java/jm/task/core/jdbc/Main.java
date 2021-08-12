package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Алексей", "Петров", (byte) 43);
        userService.saveUser("Петр", "Алексеев", (byte) 23);
        userService.saveUser("Лешка", "Петрович", (byte) 46);
        userService.removeUserById(1);
        userService.saveUser("Петька", "Алексеевич",(byte) 1);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
