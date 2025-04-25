package com.example.dao;

import java.sql.*;
import java.util.*;
import com.example.model.Product;

public class ProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/ecommerce";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root_pass_1234";

    private static final String SELECT_ALL = "SELECT * FROM products";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Important to avoid "No suitable driver"
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
