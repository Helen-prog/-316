package org.ee.jakarta.hospital_system.dao;

import org.ee.jakarta.hospital_system.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection conn;

    public UserDao(Connection conn) {
        this.conn = conn;
    }

    public boolean register(User user) {
        boolean flag = false;

        try {
            String sql = "insert into user_dtls(full_name, email, password) values(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public User login(String email, String password) {
        User user = null;

        try {
            String sql = "select * from user_dtls where email = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassword(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean checkOldPassword(int userId, String oldPassword) {
        boolean flag = false;

        try {
            String sql = "select * from user_dtls where id = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setString(2, oldPassword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean changePassword(int userId, String newPassword) {
        boolean flag = false;

        try {
            String sql = "update user_dtls set password = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setInt(2, userId);
            int row = ps.executeUpdate();
            if (row == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flag;
    }
}
