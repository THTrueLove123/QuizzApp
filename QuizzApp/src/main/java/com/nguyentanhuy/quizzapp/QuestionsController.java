/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.nguyentanhuy.quizzapp;

import com.nguyentanhuy.services.CategoryServices;
import com.nguyentanhuy.utils.MyConnectionSingleton;
import com.nguyentanhuy.pojo.Category;
import com.nguyentanhuy.pojo.Choice;
import com.nguyentanhuy.pojo.Level;
import com.nguyentanhuy.pojo.Question;
import com.nguyentanhuy.services.LevelServices;
import com.nguyentanhuy.services.question.QuestionServices;
import com.nguyentanhuy.utils.Config;
import com.nguyentanhuy.utils.MyAlertSingleton;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author admin
 */
public class QuestionsController implements Initializable {

    @FXML
    private ComboBox<Category> cBoCate;
    @FXML
    private TableView<Question> tvQuestion;
    @FXML
    private ComboBox<Level> cBLvl;
    @FXML
    private VBox vChoices;
    @FXML
    private TextArea txtContent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {

            this.loadColumn();
            this.cBoCate.setItems(FXCollections.observableList(Config.cateServices.getCates()));
            this.cBLvl.setItems(FXCollections.observableList(Config.lvlServies.getLevels()));

        } catch (SQLException ex) {
//            Logger.getLogger(QuestionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadTableQuestion();
    }

    public void loadColumn() {
        TableColumn colId = new TableColumn("Id");
        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colId.setPrefWidth(100);

        TableColumn colContent = new TableColumn("Nội dung câu hỏi");
        colContent.setCellValueFactory(new PropertyValueFactory("content"));
        colContent.setPrefWidth(300);

        this.tvQuestion.getColumns().addAll(colId, colContent);

    }

    public void addChoices(ActionEvent e) {
        HBox h = new HBox();
        h.getStyleClass().add("Container");

        RadioButton r = new RadioButton();
        TextField txt = new TextField();

        h.getChildren().addAll(r, txt);

        this.vChoices.getChildren().add(h);
    }

    public void addQuestion(ActionEvent e) {
        Question q = new Question.QuestionBuilder().setCategory(this.cBoCate.getSelectionModel().getSelectedItem())
                .setContent(this.txtContent.getText())
                .setLevel(this.cBLvl.getSelectionModel().getSelectedItem()).build();
        List<Choice> choices = new ArrayList<>();
        for (var hbox : this.vChoices.getChildren()) {
            HBox h = (HBox) hbox;
            RadioButton r = (RadioButton) h.getChildren().get(0);
            TextField txt = (TextField) h.getChildren().get(1);

            choices.add(new Choice(txt.getText(), r.isSelected()));
        }
        try {
            Optional<ButtonType> b = MyAlertSingleton.getInstance().showMeg("bạn có chắc chắn không?", Alert.AlertType.CONFIRMATION);
            if (b.isPresent() && b.get() == ButtonType.OK) {
                Config.uQuestionServies.addQuestion(q, choices);

                MyAlertSingleton.getInstance().showMeg("Thêm câu hỏi thành công");
                loadTableQuestion();
            }

        } catch (SQLException ex) {
            MyAlertSingleton.getInstance().showMeg("Thêm câu hỏi thất bại, do" + ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
    private void loadTableQuestion () {
        try {
            this.tvQuestion.setItems(FXCollections.observableList(Config.questionServices.getQuestion()));
        } catch (SQLException ex) {
            Logger.getLogger(QuestionsController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
