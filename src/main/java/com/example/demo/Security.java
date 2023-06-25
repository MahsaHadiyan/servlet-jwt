package com.example.demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by M.Hadiyan
 * Date: 6/25/2023
 * Time: 1:40 PM
 **/

@Retention(RetentionPolicy.RUNTIME)
public @interface Security {

    String[] roles= {"admin","person","default"};
}
