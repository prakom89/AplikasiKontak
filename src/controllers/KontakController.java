/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.SQLiteConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Kontak;

/**
 *
 * @author ACER
 */
public class KontakController {
//    /**
//     * Menambahkan kontak baru ke database.
//     * @param kontak Objek kontak yang akan ditambahkan.
//     */

    public static void tambahKontak(Kontak kontak) {
        String sql = "INSERT INTO kontak (nama, nomor_telepon, kategori) VALUES (?, ?, ?)";

        try (Connection conn = SQLiteConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, kontak.getNama());
            pstmt.setString(2, kontak.getNomorTelepon());
            pstmt.setString(3, kontak.getKategori());
            pstmt.executeUpdate();

            System.out.println("Kontak berhasil ditambahkan.");
        } catch (SQLException e) {
            System.out.println("Gagal menambahkan kontak: " + e.getMessage());
        }
    }

//    /**
//     * Mengambil semua kontak dari database.
//     * @return Daftar semua kontak.
//     */
    public static List<Kontak> getSemuaKontak() {
        String sql = "SELECT * FROM kontak";
        List<Kontak> daftarKontak = new ArrayList<>();

        try (Connection conn = SQLiteConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Kontak kontak = new Kontak(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("nomor_telepon"),
                        rs.getString("kategori")
                );
                daftarKontak.add(kontak);
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil daftar kontak: " + e.getMessage());
        }

        return daftarKontak;
    }

//    /**
//     * Mengupdate data kontak di database.
//     * @param kontak Objek kontak dengan data terbaru.
//     */
    public static void updateKontak(Kontak kontak) {
        String sql = "UPDATE kontak SET nama = ?, nomor_telepon = ?, kategori = ? WHERE id = ?";

        try (Connection conn = SQLiteConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, kontak.getNama());
            pstmt.setString(2, kontak.getNomorTelepon());
            pstmt.setString(3, kontak.getKategori());
            pstmt.setInt(4, kontak.getId());
            pstmt.executeUpdate();

            System.out.println("Kontak berhasil diperbarui.");
        } catch (SQLException e) {
            System.out.println("Gagal memperbarui kontak: " + e.getMessage());
        }
    }

//    /**
//     * Menghapus kontak dari database.
//     * @param id ID kontak yang akan dihapus.
//     */
    public static void hapusKontak(int id) {
        String sql = "DELETE FROM kontak WHERE id = ?";

        try (Connection conn = SQLiteConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Kontak berhasil dihapus.");
        } catch (SQLException e) {
            System.out.println("Gagal menghapus kontak: " + e.getMessage());
        }
    }

//    /**
//     * Mencari kontak berdasarkan nama atau nomor telepon.
//     * @param keyword Kata kunci pencarian.
//     * @return Daftar kontak yang cocok.
//     */
    public static List<Kontak> cariKontak(String keyword) {
        String sql = "SELECT * FROM kontak WHERE nama LIKE ? OR nomor_telepon LIKE ?";
        List<Kontak> hasilPencarian = new ArrayList<>();

        try (Connection conn = SQLiteConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Kontak kontak = new Kontak(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("nomor_telepon"),
                        rs.getString("kategori")
                );
                hasilPencarian.add(kontak);
            }
        } catch (SQLException e) {
            System.out.println("Gagal mencari kontak: " + e.getMessage());
        }

        return hasilPencarian;
    }

    public static List<Kontak> getKontakByKategori(String kategori) {
        List<Kontak> daftarKontak = new ArrayList<>();
        String sql = "SELECT * FROM kontak WHERE kategori = ?";

        try (Connection conn = SQLiteConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, kategori);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Kontak kontak = new Kontak(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("nomor_telepon"),
                        rs.getString("kategori")
                );
                daftarKontak.add(kontak);
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data kontak berdasarkan kategori: " + e.getMessage());
        }

        return daftarKontak;
    }
}
