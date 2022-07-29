/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.soniworld.packages.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.soniworld.packages.dao.EmployeeDao;
import com.soniworld.packages.model.employees;
import jakarta.servlet.annotation.WebServlet;

/**
 * @author Soni Pratham K
 */
@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao;

    public void init() {
        employeeDao = new EmployeeDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String name = request.getParameter("firstName");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        employees employee = new employees();
        employee.setName(name);
        employee.setEmail(email);
        employee.setPassword(password);

        try {
            employeeDao.registerEmployee(employee);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("employeedetails.jsp");
    }
}