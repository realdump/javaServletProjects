package com.ecommerce.dao;

import java.sql.*;

public class UserDAO {

    public static boolean registerUser(String name, String email, String password) {
        boolean success = false;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO users(name, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            success = stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public static boolean validateUser(String email, String password) {
        boolean valid = false;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            valid = rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return valid;
    }
}
