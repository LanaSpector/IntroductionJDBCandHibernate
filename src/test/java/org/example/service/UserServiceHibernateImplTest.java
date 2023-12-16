package org.example.service;

import org.hibernate.HibernateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceHibernateImplTest {
    private final String testName = "Lilu";
    private final String testLastName = "Dallas";
    private final byte testAge = 31;

    private final UserService userService = new UserServiceHibernateImpl();

    @BeforeEach
    void tuning() {
        userService.dropUserTable();
        userService.createUserTable();
        userService.saveUser(testName, testLastName, testAge);
    }

    @Test
    void createUserTable() {
        try {
            userService.dropUserTable();
            userService.createUserTable();
        } catch (Exception e) {
            fail("При тестировании создания таблицы, выбросился Exception" + e.getMessage());
        }

//        userService.dropUserTable();
////        assertThrows(HibernateException.class, userService::createUserTable);
//        assertDoesNotThrow(userService::createUserTable);
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