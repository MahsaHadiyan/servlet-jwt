package com.example.demo.controller;

import com.example.demo.jwtWrapper.JWTGenerator;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.lang.JoseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameterValues("username")[0];
        RsaJsonWebKey rsaJsonWebKey = null;
        try {
            rsaJsonWebKey = JWTGenerator.getInstance().getRsaJsonWebKey();
        } catch (JoseException e) {
            throw new RuntimeException(e);
        }
        List<String> roles = new ArrayList<>();
        roles.add("person");
        roles.add("default");
        JwtClaims jwtClaims = JWTGenerator.getInstance().getJwtClaims(name, roles);
        String jwtSignature = null;
        try {
            jwtSignature = JWTGenerator.getInstance().getJwtSignature(rsaJsonWebKey, jwtClaims);
        } catch (JoseException e) {
            throw new RuntimeException(e);
        }
        JwtConsumer jwtConsumer = JWTGenerator.getInstance().getJwtConsumer(rsaJsonWebKey);
        try {
            JWTGenerator.getInstance().validate(jwtSignature, jwtConsumer);
        } catch (MalformedClaimException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("POST EXECUTED...");
    }

}
