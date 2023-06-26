package com.example.demo.controller;

import com.example.demo.annotation.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by M.Hadiyan
 * Date: 6/25/2023
 * Time: 2:13 PM
 **/
public abstract class BaseServlet<E> extends HttpServlet {

    private Controller controllerAnnotation;

    @Override
    public void init() throws ServletException {
        controllerAnnotation = this.getClass().getDeclaredAnnotation(Controller.class);
    }

    public abstract void doService(E e);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            setObjectFromRequest(req,controllerAnnotation.entity());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    private <T> T setObjectFromRequest(HttpServletRequest req, Class<T> aClass) throws Exception {
        List<String> params = new ArrayList<>();
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            out.write(paramName.getBytes());
            params.add(paramName);
        }
        List<Field> fieldsList = new ArrayList<>(Arrays.asList(aClass.getDeclaredFields()));
        T object = aClass.getDeclaredConstructor().newInstance();
        for (String param : params) {
            fieldsList
                    .stream()
                    .filter(f -> f.getName().equals(param))
                    .forEach(f -> {
                        f.setAccessible(true);
                        try {
                            f.set(object, req.getParameter(param));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
        }

        return object;

    }

}
