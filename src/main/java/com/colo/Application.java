package com.colo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.*;
import java.util.Arrays;

/**
 * Created by rehacek on 10/3/2017.
 */
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan//( basePackages = {"com.colo.data"} )
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver).newInstance();
        String protocol = "jdbc:mysql:";
        Connection conn = DriverManager.getConnection(protocol + "//localhost:3306/world","root","root");
        init(conn);
        Statement stmt = conn.createStatement();
        String query = "SELECT ID, NAME FROM FIRSTTABLE";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            System.out.println("ID" + rs.getInt("ID") + " NAME: " + rs.getString("NAME") );
        }
        stmt.close();
        conn.close();

        SpringApplication.run(Application.class, args);
    }

    private static void init(Connection conn) throws SQLException {
        DatabaseMetaData dbmd = conn.getMetaData();
        ResultSet rs = dbmd.getTables(null, null, "FIRSTTABLE", null);
        if (rs.next()) {
            System.out.println("Table " +  rs.getString(3) + " exists");
        } else {
            Statement stmt = conn.createStatement();
            String query = "CREATE TABLE FIRSTTABLE (ID INT PRIMARY KEY, NAME VARCHAR(12))";
            stmt.executeUpdate(query);
            stmt.close();
            stmt = conn.createStatement();
            query = "INSERT INTO FIRSTTABLE VALUES (10,'TEN'),(20,'TWENTY'),(30,'THIRTY')";
            stmt.executeUpdate(query);
            stmt.close();
        }
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
        };

    }

}
