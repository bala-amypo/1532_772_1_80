package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class SimpleStatusServlet extends HttpServlet {

    @Override
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);

        response.getWriter().write("{\"status\":\"UP\"}");
    }
}
