package rest.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by andriusbaltrunas on 5/24/2018.
 */
public class DbUtils {

    public Connection createConnection() {
        InputStream inputStream = getClass().getResourceAsStream("../../../properties/db.properties");
        Properties properties = new Properties();
        Connection connection = null;
        try {
            properties.load(inputStream);
            getClass().forName(properties.getProperty("db.drivers"));
            connection = DriverManager.getConnection(properties.getProperty("db.url"),
                    properties.getProperty("db.username"),
                    properties.getProperty("db.password"));
        } catch (Exception e) {
            System.out.println("KLAIDA " + e);
        }
        return connection;
    }
}
