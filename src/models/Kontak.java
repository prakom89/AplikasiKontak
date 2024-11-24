/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ACER
 */
public class Kontak {

    private int id; // ID unik untuk setiap kontak
    private String nama; // Nama kontak
    private String nomorTelepon; // Nomor telepon kontak
    private String kategori; // Kategori kontak (Keluarga, Teman, Kerja, dll.)

    // Konstruktor tanpa parameter (default).
  
    public Kontak() {
    }

    // Konstruktor dengan parameter lengkap.
    // @param id ID kontak
    // @param nama Nama kontak
    // @param nomorTelepon Nomor telepon kontak
    // @param kategori Kategori kontak

    public Kontak(int id, String nama, String nomorTelepon, String kategori) {
        this.id = id;
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.kategori = kategori;
    }

    // Getter dan Setter untuk setiap atribut
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }


    //  Override metode toString untuk mencetak informasi kontak.
    //  @return String yang merepresentasikan kontak.
    @Override
    public String toString() {
        return "Kontak{"
                + "id=" + id
                + ", nama='" + nama + '\''
                + ", nomorTelepon='" + nomorTelepon + '\''
                + ", kategori='" + kategori + '\''
                + '}';
    }
}
