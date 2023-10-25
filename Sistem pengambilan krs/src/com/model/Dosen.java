
package com.model;


public class Dosen extends person_parent{
    
    String NIP;

    public Dosen(String NIP, String Nama, String Alamat, String No_Hp, String Email) {
        super(Nama, Alamat, No_Hp, Email);
        this.NIP = NIP;
    }

   
}
