/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nguyentanhuy.utils;

import com.nguyentanhuy.services.CategoryServices;
import com.nguyentanhuy.services.LevelServices;
import com.nguyentanhuy.services.question.QuestionServices;
import com.nguyentanhuy.services.question.UpdateQuestionServices;

/**
 *
 * @author admin
 */
public class Config {

    public static final CategoryServices cateServices = new CategoryServices();
    public static final QuestionServices questionServices = new QuestionServices();
    public static final LevelServices lvlServies = new LevelServices();
     public static final UpdateQuestionServices uQuestionServies = new UpdateQuestionServices();
}
