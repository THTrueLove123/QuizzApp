/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyentanhuy.themes;

import com.nguyentanhuy.quizzapp.App;
import javafx.scene.Scene;

/**
 *
 * @author ASUS
 */
public class ThemesManager {
    private static ThemesAbstractFactory factory = new DefaultFactory();


    public static void applyTheme (Scene scene) {
        scene.getRoot().getStylesheets().clear();
        scene.getRoot().getStylesheets().add(factory.getStyleSheet());
    }

    public static void setFactory(ThemesAbstractFactory aFactory) {
        factory= aFactory;
    }
}
