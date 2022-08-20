package com.bridgelabz_dbautomationtesting;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.bridgelabz_dbautomationtesting.BaseClass.connection;
import static com.bridgelabz_dbautomationtesting.BaseClass.setUp;

public class DbAutomation {
    @Test
    public void dbTest_ExecuteSelectData() throws SQLException, ClassNotFoundException {
        connection = setUp();
        System.out.println("Connection established");
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("select * from upload");

        while (resultset.next()) {
            int user_id = resultset.getInt(1);
            String user_name = resultset.getString(2);
            String user_type = resultset.getString(3);
            System.out.println(user_id + " " + user_name + " " + user_type);
        }
        System.out.println("Getting all upload data table");
    }
    @Test
    public void dbTest_InsertData() throws SQLException, ClassNotFoundException {
        connection = setUp();
        PreparedStatement preparedStatement = connection.prepareStatement("Insert into upload values(?,?,?)");
        preparedStatement.setInt(1, 6) ;
        preparedStatement.setString(2, "Rajkanya");
        preparedStatement.setString(3, "Admin");
        System.out.println("Successfully inserted");
    }
    @Test
    public void dbTest_UpdateData() throws SQLException, ClassNotFoundException {
        connection = setUp();
        PreparedStatement preparedStatement = connection.prepareStatement("update upload set user_name='Ashu', where user_id=6");
        preparedStatement.executeUpdate();
        System.out.println("Updated successfully !!");
    }
    @Test
    public void dbTest_DeleteData() throws SQLException, ClassNotFoundException {
        connection = setUp();
        System.out.println("Connection established");
        PreparedStatement preparedStatement = connection.prepareStatement("delete from upload where user_id=(?)");
        preparedStatement.setString(6, "Rajkanya");
        System.out.println("Getting all deleted data successfully");
    }
}

