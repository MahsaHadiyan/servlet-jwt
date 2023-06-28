package com.example.demo.filter;

import com.example.demo.tools.CacheContainer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * * Date          Author             Task ID         Notes
 * * ==========   =================   ==============  ======================
 * * 6/24/2023        M.Hadiyan
 **/

@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {

    List<String> paths = Arrays.asList("/login", "/logout", "/signup");


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String servletName = request.getHttpServletMapping().getServletName();
        if (!CacheContainer.getInstance().getRoleMap().containsKey(servletName)) {
            filterChain.doFilter(servletRequest, servletResponse);//sends request to next resource
        } else {
            Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("jwt")) {
                    String value = cookie.getValue();
                }
            }
            //az header token ra begir
        }


    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
