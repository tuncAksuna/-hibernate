package com.tuncode.hibernate.demo.onetomanybidirectional.JDBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTest {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String pass = "M.orkazak2323.";

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
