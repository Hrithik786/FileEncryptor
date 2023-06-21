package DAO;

import db.MyConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static boolean isExists(String email) throws SQLException {
        Connection connection = MyConnection.getConnection();
        //getting connection

        PreparedStatement ps = connection.prepareStatement("select email from users");
        ResultSet res = ps.executeQuery();
        //executing SQLquery

        while(res.next()){
            String e = res.getString(1);
            if (e.equals(email))
                return true;
        }
        return false;
    }
    public static int saveUser(User user) throws SQLException{
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("insert into users values(default,?,?)");
        ps.setString(1,user.getName());
        ps.setString(2,user.getEmail());
        return ps.executeUpdate();
    }
}
