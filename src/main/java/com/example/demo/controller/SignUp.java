package com.example.demo.controller;

import com.example.demo.exception.ClaimNotFoundException;
import com.example.demo.jwtWrapper.JWTGenerator;
import com.example.demo.tools.CacheContainer;
import com.example.demo.tools.XmlReader;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.MalformedClaimException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.lang.JoseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by M.Hadiyan
 * Date: 6/24/2023
 * Time: 9:38 AM
 **/
@WebServlet(name = "signup", value = "/signup.do")
public class SignUp extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameterValues("username")[0];
        String jwt = null;
        try {
            jwt = setJwt(userName);
        } catch (JoseException e) {
            throw new RuntimeException(e);
        }
        Cookie cookie = new Cookie("jwt", jwt);
        resp.addCookie(cookie);
        resp.sendRedirect("/index.jsp");
    }

    private static String setJwt(String name) throws JoseException {
        RsaJsonWebKey rsaJsonWebKey = null;
        try {
            rsaJsonWebKey = JWTGenerator.getInstance().getRsaJsonWebKey();
        } catch (JoseException e) {
            throw new JoseException("");
        }
        List<String> roles = new ArrayList<>();
        roles.add("default");
        JwtClaims jwtClaims = JWTGenerator.getInstance().getJwtClaims(name, roles);
        String jwtSignature = null;
        try {
            jwtSignature = JWTGenerator.getInstance().getJwtSignature(rsaJsonWebKey, jwtClaims);
        } catch (JoseException e) {
            throw new JoseException("e");
        }
        JwtConsumer jwtConsumer = JWTGenerator.getInstance().getJwtConsumer(rsaJsonWebKey);
        try {
            JWTGenerator.getInstance().validate(jwtSignature, jwtConsumer);
        } catch (MalformedClaimException e) {
            throw new JoseException("");
        }
        return jwtSignature;
    }
}
