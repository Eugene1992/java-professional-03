package com.cbu.edu.JDBC.Connect;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by Sviatoslav on 10.03.2017.
 */
public class MyConnection {
    private static MyConnection connection = new MyConnection();
    private static final String PATH = "E:\\ProjectAndOther\\IDEAProjects\\java-professional-03\\sviatoslav\\src\\main\\java\\resources\\sql.properties";

    public MyConnection() {
    }

    private Connection connect() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(PATH)) {
            properties.load(fis);
            final String url = properties.getProperty("url");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(":((((((");
        }
    }

    public static Connection getConnect() {
        return connection.connect();
    }
}
