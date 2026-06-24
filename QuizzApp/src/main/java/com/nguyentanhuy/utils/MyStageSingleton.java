/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyentanhuy.utils;


import com.nguyentanhuy.quizzapp.App;
import com.nguyentanhuy.themes.ThemesManager;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class MyStageSingleton {
    private static MyStageSingleton instance;
    private final Stage stage;
    
    private MyStageSingleton() {
        this.stage = new Stage();
        this.stage.setTitle("Quản Lý Câu Hỏi");
    }
    public static MyStageSingleton getInstance(){
        if (instance==null)
            instance = new MyStageSingleton();
        return instance;
    }
    public void showStage(String c){
        if (!this.stage.isShowing()) {
            try {
            Scene scene = new Scene(new FXMLLoader(App.class.getResource( c + ".fxml")).load());
            
            ThemesManager.applyTheme(scene);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        }
        
    }
}
