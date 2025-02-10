package com.file_hiding_system.dao;

import com.file_hiding_system.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public User getUerByEmail(String email) throws Exception {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "SELECT * FROM users WHERE email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getString("id"), rs.getString("email"),
                        rs.getString("password"));
            }
        }
        return null;
    }

    public void saveUser(String email, String password) throws Exception {
        try (Connection conn = DatabaseUtil.getConnection()) {
            String sql = "INSERT INTO USERS (email, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            stmt.executeUpdate();
        }
    }
}
