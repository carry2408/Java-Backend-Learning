package com.vr.serverletapp1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class Add extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int num1 =Integer.parseInt(req.getParameter("num1"));
        int num2 =Integer.parseInt(req.getParameter("num2"));
        int sum = num1+num2;
        req.setAttribute("sum",sum);
        RequestDispatcher rd = req.getRequestDispatcher("add.jsp");
        rd.forward(req,res);
    }
}
