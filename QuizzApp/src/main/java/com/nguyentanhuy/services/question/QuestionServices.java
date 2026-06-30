/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyentanhuy.services.question;

import com.nguyentanhuy.pojo.Category;
import com.nguyentanhuy.pojo.Question;
import com.nguyentanhuy.services.CategoryServices;
import com.nguyentanhuy.utils.MyConnectionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class QuestionServices {
    public List<Question> getQuestion() throws SQLException {
                Connection conn = MyConnectionSingleton.getIntance().connect();

        String sql = "SELECT * FROM question";
        PreparedStatement stm = conn.prepareCall(sql);
        ResultSet rs = stm.executeQuery();
       List<Question> question = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                
                question.add(new Question.QuestionBuilder().setId(id).setContent(content).build());
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return question;
    }
}
