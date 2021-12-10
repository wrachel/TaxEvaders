package com.project.passwordmanager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class db_init {
    public static void init(String url) {
        Connection conn = null;
        String init_query = "CREATE TABLE IF NOT EXISTS work (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + " link text NOT NULL,\n"
                + " date text NOT NULL\n"
                + ");";

        try { // make sure connection can be established
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try { // additional connection validations
                if (conn != null) {
                    Statement query = conn.createStatement();
                    query.execute(init_query);
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        String url = "jdbc:sqlite:test.db";
        init(url);
    }
}