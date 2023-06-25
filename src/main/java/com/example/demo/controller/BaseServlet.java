package com.example.demo.controller;

import com.example.demo.entity.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by M.Hadiyan
 * Date: 6/25/2023
 * Time: 2:13 PM
 **/
public  abstract class BaseServlet<E> extends HttpServlet {

    private Controller controllerAnnotation;

    @Override
    public void init() throws ServletException {
        controllerAnnotation = this.getClass().getDeclaredAnnotation(Controller.class);
    }
    public abstract void doService(E e);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      try {
          System.out.println(controllerAnnotation.entity());
//          Person person = new Person();
//          person.setName(req.getParameter("name"));
//          person.setFamily(req.getParameter("family"));
//          doService(person);
      }catch (Exception e){
          System.out.println(e.toString());
      }
    }
}
