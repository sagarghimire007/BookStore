package com.bookstore.controller.admin.admin;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminLoginFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request , ServletResponse response , FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpRequest= (HttpServletRequest) request;

//        System.out.println(httpRequest.getRequestURI());

        HttpSession session = httpRequest.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("fullName") != null; // both session and attribute must not be null

        String loginURI = httpRequest.getContextPath() + "/admin/login";

        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);

        boolean loginPage = httpRequest.getRequestURI().endsWith("login.jsp");

        if(loggedIn && (loginRequest || loginPage)){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
            requestDispatcher.forward(request,response);
        }

        else if(loggedIn || loginRequest){
            System.out.println("user logged in");
            chain.doFilter(request , response);
        }else{
            System.out.println("user cannot logged in");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request,response);
        }

    }
}
