package com.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mahasiswa extends person_parent {
    protected String NIM;

    public Mahasiswa(String NIM, String Nama, String Alamat, String No_Hp, String Email) {
        super(Nama, Alamat, No_Hp, Email);
        this.NIM = NIM;
    }

    

    // Method untuk menambahkan data mahasiswa ke database
    public void createMahasiswa(Connection connection) throws SQLException {
        String insertQuery = "INSERT INTO mahasiswa (NIM, Nama, Alamat, No_Hp, Email) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, NIM);
        preparedStatement.setString(2, Nama);
        preparedStatement.setString(3, Alamat);
        preparedStatement.setString(4, No_Hp);
        preparedStatement.setString(5, Email);
        preparedStatement.executeUpdate();
    }

    // Method untuk membaca data mahasiswa dari database
    public static List<Mahasiswa> readMahasiswa(Connection connection) throws SQLException {
        List<Mahasiswa> mahasiswaList = new ArrayList<>();
        String selectQuery = "SELECT NIM, Nama, Alamat, No_Hp, Email FROM mahasiswa";
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String NIM = resultSet.getString("NIM");
            String Nama = resultSet.getString("Nama");
            String Alamat = resultSet.getString("Alamat");
            String No_Hp = resultSet.getString("No_Hp");
            String Email = resultSet.getString("Email");

        }
        return mahasiswaList;
    }

    // Method untuk memperbarui data mahasiswa di database
    public void updateMahasiswa(Connection connection) throws SQLException {
        String updateQuery = "UPDATE mahasiswa SET Nama = ?, Alamat = ?, No_Hp = ?, Email = ? WHERE NIM = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setString(1, Nama);
        preparedStatement.setString(2, Alamat);
        preparedStatement.setString(3, No_Hp);
        preparedStatement.setString(4, Email);
        preparedStatement.setString(5, NIM);
        preparedStatement.executeUpdate();
    }

    // Method untuk menghapus data mahasiswa dari database
    public void deleteMahasiswa(Connection connection) throws SQLException {
        String deleteQuery = "DELETE FROM mahasiswa WHERE NIM = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setString(1, NIM);
        preparedStatement.executeUpdate();
    }
}
