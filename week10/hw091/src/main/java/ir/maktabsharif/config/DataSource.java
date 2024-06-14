package ir.maktabsharif.config;

import ir.maktabsharif.util.ApplicationProperties;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSource {
    @Getter
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

}
