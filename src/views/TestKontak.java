/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.KontakController;
import java.util.List;
import models.Kontak;

/**
 *
 * @author ACER
 */
public class TestKontak {
    public static void main(String[] args) {
        // Panggil metode getSemuaKontak untuk mengambil data dari database
        List<Kontak> daftarKontak = KontakController.getSemuaKontak();

        // Cetak hasil ke konsol
        if (daftarKontak.isEmpty()) {
            System.out.println("Tidak ada kontak yang ditemukan di database.");
        } else {
            System.out.println("Daftar Kontak:");
            for (Kontak kontak : daftarKontak) {
                System.out.println("ID: " + kontak.getId() +
                                   ", Nama: " + kontak.getNama() +
                                   ", Nomor Telepon: " + kontak.getNomorTelepon() +
                                   ", Kategori: " + kontak.getKategori());
            }
        }
    }
}
