package com.vr.demo;

import com.vr.demo.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection;
        try {
           connection = JdbcUtil.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (connection != null) {
            System.out.println("Connected to database successfully");
        }
        else{
            System.out.println("Connection to database failed");
        }
    }
}
