
package com.model;

import com.controller.DataBases;

public class Mata_Kuliah {
    private DataBases db = new DataBases();
    
    String Kode_MK;
    String Nama_MK;
    String SKS;
    String Semester;
    String Praktikum;

    public Mata_Kuliah(String Kode_MK, String Nama_MK, String SKS, String Semester, String Praktikum) {
        this.Kode_MK = Kode_MK;
        this.Nama_MK = Nama_MK;
        this.SKS = SKS;
        this.Semester = Semester;
        this.Praktikum = Praktikum;
    }
    
    public boolean create() {
//        this.db.Con.createStatement()
        return false;
//        this.db.Con.createStatement()
    }
  
}
