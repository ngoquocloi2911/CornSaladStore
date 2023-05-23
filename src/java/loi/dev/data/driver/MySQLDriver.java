package loi.dev.data.driver;

import java.sql.Connection;
import java.sql.DriverManager;
import loi.dev.util.Constants;

public class MySQLDriver {

    private static MySQLDriver instance;

    private MySQLDriver() {
    }

//    Chỉ tạo 1 đối tượng 
    // 
    public static MySQLDriver getInstance() {
        if (instance == null) {
            instance = new MySQLDriver();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(Constants.DB_URL, Constants.USER, Constants.PASS);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
