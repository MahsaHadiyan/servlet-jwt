package com.example.demo.controller;

import com.example.demo.tools.CacheContainer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.net.URL;


public class HomeController extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            URL resource = config.getServletContext().getResource("WEB-INF/classes");
            CacheContainer cacheContainer = CacheContainer.getInstance();
            cacheContainer.createCacheContainer(new File(resource.getFile()),".class");
        } catch (Exception e) {
            System.out.println("bad sho ke");
        }
        super.init(config);
    }
}
