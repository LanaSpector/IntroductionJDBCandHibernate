package org.example.service;

import org.example.model.User;
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
        userService.dropUserTable();
        assertDoesNotThrow(userService::createUserTable);
    }

    @Test
    void dropUserTable() {
        assertDoesNotThrow(userService::dropUserTable);
    }

    @Test
    void saveUser() {
        User user = new User(1, testName, testLastName, testAge);
        assertEquals(user, userService.getAllUsers().get(0));
    }

    @Test
    void removeUserById() {
        userService.removeUserById(1);
        assertTrue(userService.getAllUsers().isEmpty(), "Проверьте корректность работы метода удаления пользователя");
    }

    @Test
    void getAllUsers() {
        assertFalse(userService.getAllUsers().size() != 1, "Проверьте корректность работы метода сохранения/удаления пользователей");
    }

    @Test
    void clearUserTable() {
        userService.clearUserTable();
        assertTrue(userService.getAllUsers().isEmpty(), "Метод очистки реализован некорректно");
    }
}