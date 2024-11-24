/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;

/**
 *
 * @author ACER
 */
public class TestSQLiteConnection {
    public static void main(String[] args) {
        Connection conn = SQLiteConnection.connect();

        if (conn != null) {
            System.out.println("Koneksi ke database berhasil.");
        } else {
            System.out.println("Koneksi ke database gagal.");
        }
    }
}
