package org.example;

import org.example.dao.UserDaoJDBCImpl;
import org.example.model.User;
import org.example.service.UserService;
import org.example.service.UserServiceHibernateImpl;
import org.example.service.UserServiceJDBCImpl;
import org.example.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        script(new UserServiceJDBCImpl());
        script(new UserServiceHibernateImpl());
    }

    public static void script(UserService userService) {
        userService.createUserTable();

        userService.saveUser("Rachel", "Green", (byte) 25);
        userService.saveUser("Monica", "Geller", (byte) 24);
        userService.saveUser("Phoebe", "Buffay", (byte) 27);
        userService.saveUser("Joey", "Tribbiani", (byte) 26);
        userService.saveUser("Chandler", "Bing", (byte) 28);

        List<User> allUsers = userService.getAllUsers();
        allUsers.forEach(System.out::println);

        userService.clearUserTable();
        userService.dropUserTable();
    }
}