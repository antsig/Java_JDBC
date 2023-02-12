/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbc_uas;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Bendahara
 */
public class JDBC_UAS {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/java_jdbc";
    static final String USER = "root";
    static final String PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) {
        try {
            Class.forName(JDBC_DRIVER);
 
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
 
            stmt = conn.createStatement();
            String sql = "SELECT * FROM mahasiswa";
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                System.out.println("NIM: " + rs.getInt("nim"));
                System.out.println("Nama: " + rs.getString("nama"));
                System.out.println("Jurusan: " + rs.getString("jurusan"));
            }
            stmt.close();
            conn.close();
            
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
}
