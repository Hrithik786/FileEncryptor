package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    private static Connection connection = null;
    public static Connection getConnection(){
        try {
            Class.forName("java.sql.Driver");
            //load class first
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filehider","root","admin");
            //make a connection
            System.out.println("Connection Established");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeConnection(){
        if (connection != null){
            try {
                connection.close();
                System.out.println("Connection Closed!!!!!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
