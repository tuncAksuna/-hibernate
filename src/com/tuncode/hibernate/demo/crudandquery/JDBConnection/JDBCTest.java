package com.tuncode.hibernate.demo.crudandquery.JDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/..?useSSL=false&serverTimezone=UTC";
        String user = "..";
        String pass = "..";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("SUCCESFUL");

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
