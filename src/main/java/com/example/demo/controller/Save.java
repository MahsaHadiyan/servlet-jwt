package com.example.demo.controller;

import com.example.demo.entity.Roles;
import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by M.Hadiyan
 * Date: 6/24/2023
 * Time: 9:14 AM
 **/
@WebServlet(name = "Save", value = "/save.do")
public class Save extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("IM HERE");
        String userName = req.getParameterValues("name")[0];
        String password = req.getParameterValues("family")[0];
//        String roleName = req.getParameterValues("roleName")[0];
        Users users = new Users();
        users.setUserName(userName);
        users.setPassword(password);
        Roles roles = new Roles();
//        roles.setRoleName(roleName);
//        List<Roles> roles1 = new ArrayList<>();
//        roles1.add(roles);
//        users.setRoles(roles1);
        UserService.getInstance().save(users);
        resp.sendRedirect("/middle.jsp");
    }
}
