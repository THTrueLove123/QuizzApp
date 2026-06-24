/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyentanhuy.services;

import com.nguyentanhuy.utils.MyConnectionSingleton;
import com.nguyentanhuy.pojo.Category;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class CategoryServices {

    public List<Category> getCates() throws SQLException {
        Connection conn = MyConnectionSingleton.getIntance().connect();

        String sql = "SELECT * FROM category";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
       List<Category> cates= new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                
                cates.add(new Category(id,name));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cates;
    }
}
