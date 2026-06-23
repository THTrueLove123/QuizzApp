/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyentanhuy.themes;

import javafx.scene.Scene;

/**
 *
 * @author admin
 */
public enum ThemeType {
    DEAFAULT {
        @Override
        public void updateThemes(Scene scene) {
              ThemesManager.setFactory(new DefaultFactory());
                ThemesManager.applyTheme(scene);
        }
    }, DARK {
        @Override
        public void updateThemes(Scene scene) {
           ThemesManager.setFactory(new DarkFactory());
                ThemesManager.applyTheme(scene);
        }
    }, LIGHT {
        @Override
        public void updateThemes(Scene scene) {
            ThemesManager.setFactory(new LightFactory());
                ThemesManager.applyTheme(scene);
        }
    };
    public abstract void updateThemes(Scene scene);
    
}
