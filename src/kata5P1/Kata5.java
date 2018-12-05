/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5P1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class Kata5 {


    public static void main(String[] args)  {
        //createTableSQL();
        String emailTxt;
        emailTxt = "C:\\Users\\Asus\\Documents\\kata5\\email.txt";
        List<String> lista;
        lista = new MailListReader().read(emailTxt); 
        lista.forEach((email) -> {
            insert(email);
            
        });
       
                    
    }
        
        

     
    
    private static void createTableSQL() {
        String sentence = "CREATE TABLE IF NOT EXISTS EMAIL (\n" 
                        + " Id integer PRIMARY KEY AUTOINCREMENT,\n"
                        + " Mail text NOT NULL);";
        try (Connection conn = DriverManager.getConnection(db());
            
            Statement stmt = conn.createStatement()) {
            stmt.execute(sentence);
            System.out.println("Tabla creada");
        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
        } 
        
    }

    private static String db() {
        return "jdbc:sqlite:Kata5.db";
    }
    
    private static Connection connect(){
        String url;
        url = db();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return conn;
    }
    public static void insert(String email) {
        String sql = "INSERT INTO EMAIL(Mail) VALUES(?)";
        try (Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1,email);
                pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        try (Connection conn = connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            // Bucle sobre el conjunto de registros.
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                rs.getString("Name") + "\t" +
                rs.getString("Apellidos") + "\t" +
                rs.getString("Departamento") + "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   
}
