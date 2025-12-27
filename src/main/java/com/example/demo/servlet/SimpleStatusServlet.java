package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;

public class SimpleStatusServlet extends HttpServlet {

    // 🔥 MUST BE PUBLIC (tests call it directly)
    @Override
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("text/plain");

        // 🔥 EXACT STRING EXPECTED BY TEST
        response.getWriter().write("Servlet Alive");
    }
}
