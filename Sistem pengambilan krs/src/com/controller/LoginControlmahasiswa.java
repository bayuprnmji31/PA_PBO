package com.controller;

import com.model.Mahasiswa;
import com.view.tampilan_login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginControlmahasiswa {
    private DataBases db = new DataBases();
    private Connection connection;
    

    public LoginControlmahasiswa() {
        // Inisialisasi koneksi database di konstruktor
        try {
            String url = "jdbc:mysql://localhost:3306/krs";
            String username = "username";
            String password = "password";
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // Handle exception (e.g., log or display an error message)
        }
    }

    public List<Mahasiswa> getAllMahasiswa() {
        try {
            // Panggil Model untuk membaca semua data mahasiswa
            return Mahasiswa.readMahasiswa(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
            return null;
        }
    }

    public void addMahasiswa(Mahasiswa mahasiswa) {
        try {
            // Panggil Model untuk menambahkan data mahasiswa
            mahasiswa.createMahasiswa(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    public void updateMahasiswa(Mahasiswa mahasiswa) {
        try {
            // Panggil Model untuk memperbarui data mahasiswa
            mahasiswa.updateMahasiswa(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }

    public void deleteMahasiswa(Mahasiswa mahasiswa) {
        try {
            // Panggil Model untuk menghapus data mahasiswa
            mahasiswa.deleteMahasiswa(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
    }
    
    public void login(tampilan_login frame) {
        if (frame.getIsi_username().getText().equals("") || String.copyValueOf(frame.getIsi_password().getPassword()).equals("")){
            JOptionPane.showMessageDialog(null, "Username dan Password tidak boleh kosong");
        }else{ try {
           ResultSet Data = db.executeSelectQuery("Select * from mahasiswa;");
            while (Data.next()) {                
                String NIM = Data.getString("NIM");
                String Nama = Data.getString("Nama");
                String Alamat = Data.getString("Alamat");
                String No_Hp = Data.getString("No_Hp");
                String Email = Data.getString("Email");
                if (frame.getIsi_username().getText().equals(Nama)&& frame.getIsi_password().getText().equals(NIM))  {
                    JOptionPane.showMessageDialog(null, "LOGIN BERHASIL");
                    break;
                }   
            }
            } catch (SQLException ex) {
                Logger.getLogger(tampilan_login.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }
            
}
