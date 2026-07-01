/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyentanhuy.utils;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author admin
 */
public class MyAlertSingleton {

    private static MyAlertSingleton instance;
    private final Alert alert;

    private MyAlertSingleton() {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("QuizzApp");
        alert.setHeaderText(("Quizz App"));
    }

    public static MyAlertSingleton getInstance() {
        if (instance == null) {
            instance = new MyAlertSingleton();
        }
        return instance;
    }

    public void showMeg(String c) {
        this.alert.setContentText(c);
        this.alert.show();
    }

    public Optional<ButtonType> showMeg(String content, Alert.AlertType type) {
        this.alert.setContentText(content);
        this.alert.setAlertType(type);
        return this.alert.showAndWait();
    }
}
