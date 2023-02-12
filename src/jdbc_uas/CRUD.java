/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc_uas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *2
 * @author Bendahara
 */
public class CRUD {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/java_jdbc";
    static final String USER = "root";
    static final String PASS = "";
    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    
    public static void main(String[] args) {
    try {
        
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        while (!conn.isClosed()) {
            showMenu();
        }
        stmt.close();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
    static void showMenu() {
    System.out.println("\n========= MENU UTAMA =========");
    System.out.println("1. Insert Data");
    System.out.println("2. Show Data");
    System.out.println("3. Edit Data");
    System.out.println("4. Delete Data");
    System.out.println("0. Keluar");
    System.out.println("");
    System.out.print("PILIHAN> ");

    try {
        int pilihan = Integer.parseInt(input.readLine());
        switch (pilihan) {
            case 0:
                System.exit(0);
                break;
            case 1:
                insertMhs();
                break;
            case 2:
                showData();
                break;
            case 3:
                updateMhs();
                break;
            case 4:
                deleteMhs();
                break;
            default:
                System.out.println("Pilihan salah!");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    static void showData() {
    String sql = "SELECT * FROM mahasiswa";
    try {
        rs = stmt.executeQuery(sql);
        
        System.out.println("+--------------------------------+");
        System.out.println("|    DATA MAHASISWA              |");
        System.out.println("+--------------------------------+");
        while (rs.next()) {
            String nim = rs.getString("nim");
            String nama = rs.getString("nama");
            String jurusan = rs.getString("jurusan");
            
            System.out.println(String.format("%s. %s -- (%s)", nim, nama, jurusan));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    static void insertMhs() {
    try {
        System.out.print("NIM: ");
        String nim = input.readLine().trim();
        System.out.print("Nama: ");
        String nama = input.readLine().trim();
        System.out.print("Jurusan: ");
        String jurusan = input.readLine().trim();
    
        String sql = "INSERT INTO mahasiswa (nim, nama, jurusan) VALUE('%s', '%s', '%s')";
        sql = String.format(sql, nim, nama, jurusan);
        
        stmt.execute(sql);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    static void updateMhs() {
    try {
        System.out.print("NIM yang mau diedit: ");
        String nim = input.readLine().trim();
        System.out.print("Nama: ");
        String nama = input.readLine().trim();
        System.out.print("Jurusan: ");
        String jurusan = input.readLine().trim();

        String sql = "UPDATE mahasiswa SET nama='%s', jurusan='%s' WHERE nim=%s";
        sql = String.format(sql, nama, jurusan, nim);

       stmt.execute(sql);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    static void deleteMhs() {
    try {
        System.out.print("NIM yang mau dihapus: ");
        String nim = input.readLine().trim();
        
        String sql = String.format("DELETE FROM mahasiswa WHERE nim=%s", nim);
        
        stmt.execute(sql);
        
        System.out.println("Data telah terhapus...");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}