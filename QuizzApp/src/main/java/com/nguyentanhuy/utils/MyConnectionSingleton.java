/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyentanhuy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class MyConnectionSingleton {
    private static MyConnectionSingleton instance;
    private Connection conn;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnectionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public MyConnectionSingleton() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/quizzdb", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnectionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static MyConnectionSingleton getIntance (){
        if (instance==null)
            instance = new MyConnectionSingleton();
        return instance;
    }
    public Connection connect (){
        return this.conn;
    }
    public void Close() {
        if (this.conn != null)
            try {
                this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MyConnectionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
