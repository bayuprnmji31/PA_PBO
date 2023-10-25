
package com.controller;

import java.util.Scanner;

public class Login {
    String[][] login1 = {{"admin","123"}};
    DataBases db = new DataBases();
    
    public boolean authenticate(String username, String password) {
        for (String[] user:login1) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
                
            }
        }
    return false;
    }
    
    public static void main(String[] args) {
        Login login = new Login();
        Scanner scanner = new Scanner(System.in);
        
        
        while (true) {            
            System.out.println("Masukan nama pengguna:");
            String username = scanner.next();
            System.out.println("Masukan password :");
            String password = scanner.next();
            
            
            if (login.authenticate(username, password)) {
                System.out.println("Login berhasil");
            }else {
                System.out.println("Login anda gagal");
            }
            
            
        }
    }
}


        
  