/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyentanhuy.services;

import com.nguyentanhuy.pojo.Category;
import com.nguyentanhuy.pojo.Level;
import com.nguyentanhuy.utils.MyConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class LevelServices {
    public List<Level> getLevels() throws SQLException {
        Connection conn = MyConnectionSingleton.getIntance().connect();

        String sql = "SELECT * FROM level";
        PreparedStatement stm = conn.prepareCall(sql);
        ResultSet rs = stm.executeQuery();
       List<Level> levels= new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                
                levels.add(new Level(id,name));
            }
        } catch (SQLException ex) {
//            Logger.getLogger(CategoryServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return levels;
    }
}
