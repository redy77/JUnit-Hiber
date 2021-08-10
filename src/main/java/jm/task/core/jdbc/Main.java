package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        final String testName = "Ivan";
        final String testLastName = "Ivanov";
        final byte testAge = 5;
        byte a = 4;
        UserService userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser(testName, testLastName, testAge);
        User user = userService.getAllUsers().get(0);
        if (!testName.equals(user.getName())
                || !testLastName.equals(user.getLastName())
                || testAge != user.getAge()

        ) {
//            System.out.println("yes");;
        }else{
            System.out.println("no");
        }
        System.out.println(user.getName());
        System.out.println(user.getLastName());
        System.out.println(user.getAge());
        System.out.println(userService.getAllUsers());



    }
}
