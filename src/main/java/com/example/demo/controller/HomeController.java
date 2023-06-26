package com.example.demo.controller;

import javax.servlet.Filter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.File;
import java.net.URL;
import java.util.Arrays;


public class HomeController extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            URL resource = config.getServletContext().getResource("WEB-INF/classes");
            File file = new File(resource.getFile());
            File[] files = file.listFiles();
            Arrays.stream(files).map(File::getName).forEach(System.out::println);
            for (File f : files) {
                while (!f.isFile()) {
                    System.out.println(f.getName() + "is file....");
                }
            }
        } catch (Exception e) {
            System.out.println("bad sho ke");
        }
        super.init(config);
    }
}
