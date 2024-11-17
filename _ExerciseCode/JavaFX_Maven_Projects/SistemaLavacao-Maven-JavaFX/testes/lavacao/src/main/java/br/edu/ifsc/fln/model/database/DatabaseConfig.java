package br.edu.ifsc.fln.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/db_lava_jato";
    private static final String USER = "java";
    private static final String PASSWORD = "java";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Conexão com o banco de dados bem-sucedida!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
