package com.project.passwordmanager;
import java.sql.*;
import java.util.Arrays;

public class sql_helper {

    private Connection connect(String url) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public ResultSet read(String url, String query) {
        try (Connection conn = this.connect(url); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)){ // establish connection
            System.out.println(rs.getString(1));
            return rs;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void write(String url, PreparedStatement pstmt) {
        try (Connection conn = this.connect(url)) {
            pstmt.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public String[][] get_work(String url) {
        String[][] work = {};

        String query = "SELECT name, link, date FROM work";

        try (Connection conn = this.connect(url); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)){ // establish connection
            while (rs.next()) {
                work = Arrays.copyOf(work, work.length + 1);
                work[work.length - 1] = new String[]{rs.getString("name"), rs.getString("link"), rs.getString("date")};
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return work;
    }

    public String[][] get_passwords(String url) {
        String[][] passwords = {};

        String query = "SELECT service, password FROM passwords";

        try (Connection conn = this.connect(url); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)){ // establish connection
            while (rs.next()) {
                passwords = Arrays.copyOf(passwords, passwords.length + 1);
                passwords[passwords.length - 1] = new String[]{rs.getString("service"), rs.getString("password")};
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return passwords;
    }

    public static void main(String[] args) {
        System.out.println("Helper operational!");
    }
}