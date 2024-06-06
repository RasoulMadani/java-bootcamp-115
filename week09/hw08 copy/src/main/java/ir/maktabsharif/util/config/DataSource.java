package ir.maktabsharif.util.config;

import ir.maktabsharif.util.ApplicationProperties;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
    private static Connection connection;
    static {
        try {
            connection = DriverManager.getConnection(
                    ApplicationProperties.URL_DB,
                    ApplicationProperties.User_Name,
                    ApplicationProperties.PASS);

        } catch (Exception e) {
            System.out.println("Error In DataSource Attribute!");
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
