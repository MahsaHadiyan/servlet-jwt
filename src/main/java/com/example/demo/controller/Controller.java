package com.example.demo.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by M.Hadiyan
 * Date: 6/25/2023
 * Time: 2:46 PM
 **/
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
    String name();
    Class<?> entity();
}
