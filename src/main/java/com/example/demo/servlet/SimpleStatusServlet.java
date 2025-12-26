package com.example.demo.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class SimpleStatusServlet extends HttpServlet {

    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException {

    response.setStatus(HttpServletResponse.SC_OK);

    PrintWriter writer = response.getWriter();
    writer.write("Servlet Alive");
}

}
