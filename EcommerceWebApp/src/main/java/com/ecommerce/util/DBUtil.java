package com.ecommerce.util;
import java.sql.*;
public class DBUtil {
	 private static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
	    private static final String USER = "root";
	    private static final String PASS = "root_pass_1234";

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASS);
	    }
}
