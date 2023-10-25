
package com.controller;
import java.sql.*;
import java.sql.DriverManager;


public class DataBases {
    public Connection Con;
    public Statement st;
    public ResultSet rs;
    
    
    public DataBases(){
        try{
            this.Con= DriverManager.getConnection("jdbc:mysql://localhost:3306/krs","root","");
            this.st =Con.createStatement();
            System.out.println("Mysql Terhubung");
         
        }catch (SQLException ex) {
            System.out.println("MYSQL ERROR" + ex.getMessage());
        }
    }
    public void closeConnection() {
        try {
            if (Con != null) {
                Con.close();
                System.out.println("Koneksi ditutup.");
            }
        } catch (SQLException ex) {
            System.out.println("Gagal menutup koneksi: " + ex.getMessage());
        }
    }
    
    public static void main(String[] args) {
      DataBases db = new DataBases();
      
    }
    
    public ResultSet executeSelectQuery(String perintah) throws SQLDataException, SQLException{
        rs =st.executeQuery(perintah);
        return rs;
    }
    
    public void executeUpdateQuery(String pth) throws SQLException{
        st.execute(pth);
    }
    
    
}
