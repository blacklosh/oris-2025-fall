package ru.itis.connection;

import java.sql.*;
import java.util.Scanner;

public class MainDatabaseConnection {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/oris-fall-2025";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "qwerty";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
        System.out.println("Driver loaded successfully!!");

        Scanner sc = new Scanner(System.in);
        String searchName = sc.nextLine();

        try (Connection connection = DriverManager.getConnection(DATABASE_URL,
                DATABASE_USER, DATABASE_PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "select * from user_entity where name = '" + searchName + "';";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                System.out.println("Got user (id = " + id + ", name = " + name + ");");
            }

        } catch (SQLException e) {
            System.err.println("Error while performing sql statement: " + e.getMessage());
        }
    }
}
