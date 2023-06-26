package com.example.demo.controller;

import com.example.demo.annotation.Security;
import com.example.demo.entity.Person;
import com.example.demo.tools.BaseParameter;

import javax.servlet.annotation.WebServlet;
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
 * Date: 6/24/2023
 * Time: 9:14 AM
 **/
@WebServlet(name = "Save", value = "/save.do")
@Security(role = BaseParameter.admin)
public class Save extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            Person person = setObjectFromRequest(req, Person.class);
            out.printf("name::", person.getName());
            out.printf("family::", person.getFamily());
            out.printf("id", person.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("/middle.jsp");
    }

    private <T> T setObjectFromRequest(HttpServletRequest req, Class<T> aClass) throws Exception {
        List<String> params = new ArrayList<>();
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            out.write(paramName.getBytes());
            params.add(paramName);
        }
        Field[] declaredFields = aClass.getDeclaredFields();
        List<Field> fieldsList = new ArrayList<>(Arrays.asList(declaredFields));
        T object = aClass.getDeclaredConstructor().newInstance();
        for (String param : params) {
//            for (Field declaredField : declaredFields) {
//                if (param.equals(declaredField.getName())) {
//                    // Apply set Method
//                    declaredField.setAccessible(true);
//                    declaredField.set(object, req.getParameter(param));
//                }
//            }
            fieldsList
                    .stream()
                    .filter(f->f.getName().equals(param))
                    .forEach(f->{
                        f.setAccessible(true);
                        try {
                            f.set(object,req.getParameter(param));
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    });
        }

        return object;

    }
}

