package dao;

import model.User;

import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import java.sql.*;

public class UserOperation implements UserOperationImpl{
    Connection con = null;

    @Override
    public Integer addUser(User user) {
        con = DataManager.getConnection();
        int n = 0;
        PreparedStatement ps = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs1 = st.executeQuery("select username,rol from tab1 where username='" + user.getUsername() + "'");
            if (rs1.next()) {
                if (rs1.getString(1).equalsIgnoreCase(user.getUsername()) && rs1.getString(2).equalsIgnoreCase(user.getRole()))
                    return 0;
            } else {
                String str = "insert into tab1 values (?,?,?)";
                ps = con.prepareStatement(str);
                System.out.println(user);
                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getRole());
                n = ps.executeUpdate();
                con.close();
                return n;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return n;
    }

    @Override
    public Integer loginUser(String username, String password) {
        con = DataManager.getConnection();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from tab1 where username='" + username + "' and pass='" + password + "'");
            int flag = 0;
            if (rs.next()) {
                if (rs.getString(3).equalsIgnoreCase("Admin")) {
                    System.out.println(rs.getString(1));
                    flag = 1;
                    return flag;
                } else if (rs.getString(3).equalsIgnoreCase("Customer")) {
                    System.out.println(rs.getString(1));
                    PreparedStatement ps = null;
                    String str = "insert into customer1 values (?)";
                    ps = con.prepareStatement(str);
                    ps.setString(1, username);
                    int n = 0;
                    n = ps.executeUpdate();
                    return n;
                } else if (rs.getString(3).equalsIgnoreCase("Guest")) {
                    System.out.println(rs.getString(1));
                    PreparedStatement ps = null;
                    String str = "insert into guest1 values (?)";
                    ps = con.prepareStatement(str);
                    ps.setString(1, username);
                    int n = 0;
                    n = ps.executeUpdate();
                    return n;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            if (e.getErrorCode()==20500 || e.getErrorCode()==20501){
                return e.getErrorCode();
            }
            else{
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}

