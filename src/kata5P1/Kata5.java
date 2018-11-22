/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5P1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class Kata5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(db());
            Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL());
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            System.out.println("XX");
            System.out.println(e.getMessage());
        } 
    }  

    private static String createTableSQL() {
        return "CREATE TABLE IF NOT EXISTS EMAIL (\n"
            + " Id integer PRIMARY KEY AUTOINCREMENT,\n"
            + " Mail text NOT NULL);";
    }

    private static String db() {
        return "jdbc:sqlite:Kata5.db";
    }
   
}
