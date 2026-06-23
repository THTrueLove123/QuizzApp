/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyentanhuy.themes;

import com.nguyentanhuy.quizzapp.App;

/**
 *
 * @author ASUS
 */
public class DefaultFactory extends ThemesAbstractFactory{

    @Override
    public String getStyleSheet() {
        return App.class.getResource("style.css").toExternalForm();
    }
    
}
