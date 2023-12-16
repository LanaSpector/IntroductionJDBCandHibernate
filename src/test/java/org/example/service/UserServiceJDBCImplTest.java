package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceJDBCImplTest {
    private final String testName = "Lilu";
    private final String testLastName = "Dallas";
    private final byte testAge = 31;

    private final UserService userService = new UserServiceJDBCImpl();

    @BeforeEach
    void tuning() {
        userService.dropUserTable();
        userService.createUserTable();
        userService.saveUser(testName, testLastName, testAge);
    }

    @Test
    void createUserTable() {
    }

    @Test
    void dropUserTable() {
        try {
            userService.dropUserTable();
        } catch (Exception e) {
            fail("При тестировании удаления таблицы, выбросился Exception" + e.getMessage());
        }
    }

    @Test
    void saveUser() {
    }

    @Test
    void removeUserById() {
    }

    @Test
    void getAllUsers() {
    }

    @Test
    void clearUserTable() {
    }
}