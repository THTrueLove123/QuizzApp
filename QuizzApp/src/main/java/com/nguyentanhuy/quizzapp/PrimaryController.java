package com.nguyentanhuy.quizzapp;

import com.nguyentanhuy.themes.ThemeType;
import com.nguyentanhuy.utils.MyAlertSingleton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class PrimaryController implements Initializable{
    @FXML private ComboBox<ThemeType> cbo;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbo.setItems(FXCollections.observableArrayList(ThemeType.values()));
    }
    
    public void manageQuestion (ActionEvent e) {
        MyAlertSingleton.getInstance().showMeg("Quản lý câu hỏi");
    }
    public void practiceQuestion (ActionEvent e) {
         MyAlertSingleton.getInstance().showMeg("Luyện tập");
    }
     public void examQuestion (ActionEvent e) {
         MyAlertSingleton.getInstance().showMeg("Luyện thi");
    }
     public void changeCBO(ActionEvent e) {
        switch (this.cbo.getSelectionModel().getSelectedItem())
        {
            case DARK:
                this.cbo.getScene().getRoot().getStylesheets().clear();
                this.cbo.getScene().getRoot().getStylesheets().add(App.class.getResource("darkstyle.css").toExternalForm());
                break;
            case LIGHT:
                this.cbo.getScene().getRoot().getStylesheets().clear();
                this.cbo.getScene().getRoot().getStylesheets().add(App.class.getResource("lightstyle.css").toExternalForm());
                break;
            default:
                this.cbo.getScene().getRoot().getStylesheets().clear();
                this.cbo.getScene().getRoot().getStylesheets().add(App.class.getResource("style.css").toExternalForm());
                break;
        }
    }
}
