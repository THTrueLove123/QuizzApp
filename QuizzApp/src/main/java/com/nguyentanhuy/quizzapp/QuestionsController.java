/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nguyentanhuy.quizzapp;

import com.nguyentanhuy.services.CategoryServices;
import com.nguyentanhuy.utils.MyConnectionSingleton;
import com.nguyentanhuy.pojo.Category;
import com.nguyentanhuy.pojo.Question;
import com.nguyentanhuy.services.question.QuestionServices;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {
    @FXML private ComboBox <Category> cBoCate;
    @FXML private TableView<Question> tvQuestion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            CategoryServices s = new CategoryServices();
            QuestionServices s2 = new  QuestionServices();
            this.loadColumn();
            this.cBoCate.setItems(FXCollections.observableList(s.getCates()));
            this.tvQuestion.setItems(FXCollections.observableList(s2.getQuestion()));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void loadColumn() {
        TableColumn colId= new TableColumn("Id");
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colId.setPrefWidth(100);
        
        TableColumn colContent= new TableColumn("Nội dung câu hỏi");
        colContent.setCellValueFactory(new PropertyValueFactory("content"));
        colContent.setPrefWidth(300);
        
        this.tvQuestion.getColumns().addAll(colId,colContent);
        
    }
    
}
