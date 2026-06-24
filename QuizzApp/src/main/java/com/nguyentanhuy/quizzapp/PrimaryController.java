package com.nguyentanhuy.quizzapp;


import com.nguyentanhuy.themes.ThemeType;

import com.nguyentanhuy.utils.MyAlertSingleton;
import com.nguyentanhuy.utils.MyStageSingleton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class PrimaryController implements Initializable{
    @FXML private ComboBox<ThemeType> cbo;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbo.setItems(FXCollections.observableArrayList(ThemeType.values()));
    }
    
    public void manageQuestion (ActionEvent e) {
        MyStageSingleton.getInstance().showStage("questions");
    }
    public void practiceQuestion (ActionEvent e) {
         MyAlertSingleton.getInstance().showMeg("Luyện tập");
    }
     public void examQuestion (ActionEvent e) {
         MyAlertSingleton.getInstance().showMeg("Luyện thi");
    }
     public void changeCBO(ActionEvent e) {
        this.cbo.getSelectionModel().getSelectedItem().updateThemes(this.cbo.getScene());
    }
}
