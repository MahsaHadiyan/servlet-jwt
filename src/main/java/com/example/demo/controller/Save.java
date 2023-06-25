package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.entity.Roles;
import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by M.Hadiyan
 * Date: 6/24/2023
 * Time: 9:14 AM
 **/
@WebServlet(name = "save", value = "/save.do")
public class Save extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameterValues("username")[0];
        String password = req.getParameterValues("password")[0];
        String roleName = req.getParameterValues("roleName")[0];
        Users users = new Users();
        users.setUserName(userName);
        users.setPassword(password);
        Roles roles = new Roles();
        roles.setRoleName(roleName);
        List<Roles> roles1 = new ArrayList<>();
        roles1.add(roles);
        users.setRoles(roles1);
        UserService.getInstance().save(users);
        resp.sendRedirect("/middle.jsp");
    }
}
