package org.example;

import org.example.dao.UserDaoJDBCImpl;
import org.example.util.Util;

public class Main {
    public static void main(String[] args) {
        new UserDaoJDBCImpl().createUserTable();

    }
}