package com.example.demo.controller;

import com.example.demo.annotation.Controller;
import com.example.demo.annotation.Security;
import com.example.demo.entity.Person;
import com.example.demo.tools.BaseParameter;

import javax.servlet.annotation.WebServlet;

/**
 * Created by M.Hadiyan
 * Date: 6/25/2023
 * Time: 7:16 AM
 **/
@WebServlet(urlPatterns = "/test",name = "assignRole")
@Controller(name= "assignRole" ,entity = Person.class)
@Security(role= BaseParameter.admin)
public class AssignRole extends BaseServlet<Person> {

    @Override
    public void doService(Person person) {
    }
}
