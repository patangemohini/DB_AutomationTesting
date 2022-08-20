package com.bridgelabz_dbautomationtesting;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass {
    public static Connection connection;

    @BeforeTest
    public static Connection setUp() throws ClassNotFoundException, SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/uploadcsv";
        String userName = "root";
        String password = "MySql@123";

        Class.forName("com.mysql.cj.jdbc.Driver");

        System.out.println("Connecting to database: " + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        return connection;
    }

    @AfterTest
    protected void tearDown() throws SQLException {
        if (connection != null) {
            try {
                System.out.println("Connection is successful...!!!!!");
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}