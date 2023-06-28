package com.example.demo.controller;

import com.example.demo.annotation.Security;
import com.example.demo.tools.BaseParameter;

import javax.servlet.annotation.WebServlet;

/**
 * Created by M.Hadiyan
 * Date: 6/24/2023
 * Time: 9:14 AM
 **/
@WebServlet(name = "signup", value = "/findAll.do")
@Security(role=BaseParameter.admin)
public class FindAll {
}
