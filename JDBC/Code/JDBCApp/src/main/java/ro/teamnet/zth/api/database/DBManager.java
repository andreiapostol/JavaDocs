package ro.teamnet.zth.api.database;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

/**
 * Created by Andrei.Apostol on 7/13/2017.
 */
public class DBManager {
    private DBManager() throws UnsupportedOperationException{

    }

    static final String CONNECTION_STRING= "jdbc:oracle:thin:@"
            + DBProperties.IP + ":" + DBProperties.PORT + ":xe";

    private static void registerDriver() throws ClassNotFoundException {
        Class.forName(DBProperties.DRIVER_CLASS);
    }//??

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        registerDriver();
        return DriverManager
                .getConnection(CONNECTION_STRING,
                        DBProperties.USER, DBProperties.PASS);
    }

    public static String checkConnection(Connection connection){
        try (Statement stmt = connection.createStatement()){
            ResultSet rs = stmt.executeQuery("SELECT 1 FROM DUAL");
            rs.next();
            return rs.getString(1);
        }
        catch (SQLException e) {
            System.out.println("Exceptie + " + e);
            return e.toString();
        }

    }
}
