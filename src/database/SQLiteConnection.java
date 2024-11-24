/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ACER
 */
public class SQLiteConnection {

    public static Connection connect() {
        String url = "jdbc:sqlite:kontak.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Koneksi ke database berhasil.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
     public static void buatTabelKontak() {
        String sql = "CREATE TABLE IF NOT EXISTS kontak (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "nama TEXT NOT NULL," +
                     "nomor_telepon TEXT NOT NULL," +
                     "kategori TEXT NOT NULL);";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabel kontak berhasil dibuat atau sudah ada.");
        } catch (Exception e) {
            System.out.println("Gagal membuat tabel: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Jalankan metode untuk membuat tabel
        buatTabelKontak();
    }
    
}
