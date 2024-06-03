package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class MySQL {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "tharinduCHA@8754");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ResultSet execute(String query) throws SQLException {
    
            Statement s = connection.createStatement();
            if (query.startsWith("SELECT") | query.startsWith("select")) {
                ResultSet resultSet = s.executeQuery(query);
                return resultSet;
            } else {
                int result = s.executeUpdate(query);
                return null;
            }
    }
}
