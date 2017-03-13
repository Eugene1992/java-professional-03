package com.cbs.edu.crurder.connection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static ConnectionFactory instance = new ConnectionFactory();
    private static final String PROPS_PATH = "D:\\trash\\java-professional-03\\app\\src\\main\\resources\\db.properties";

    private ConnectionFactory() {
    }

    private Connection createConnection() {
        Properties properties = new Properties();
        try(FileInputStream in = new FileInputStream(PROPS_PATH)) {
            properties.load(in);
            final String url = properties.getProperty("url");
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url);
        }
        catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Connection not established.");
        }
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }
}
