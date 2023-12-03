package org.example;

import org.example.dao.UserDaoJDBCImpl;
import org.example.model.User;
import org.example.service.UserService;
import org.example.service.UserServiceJDBCImpl;
import org.example.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        script(new UserServiceJDBCImpl());
    }

    public static void script(UserService userService) {
        userService.createUserTable();

        userService.saveUser("Emil", "Zolya", (byte) 45);
        userService.saveUser("Rosa", "Luxenburg", (byte) 34);
        userService.saveUser("Ildar", "Khabibullin", (byte) 27);
        userService.saveUser("Ilya", "Zolotov", (byte) 32);
        userService.saveUser("Karl", "Marks", (byte) 70);

        List<User> allUsers = userService.getAllUsers();
        allUsers.forEach(System.out::println);

        userService.clearUserTable();
        userService.dropUserTable();
    }
}