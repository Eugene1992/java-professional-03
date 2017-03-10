package com.cbs.edu.crurder.controller;

import com.cbs.edu.crurder.dao.EmployeeDAOImpl;
import com.cbs.edu.crurder.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        List<Employee> employees = employeeDAO.readAll();
        PrintWriter printWriter = resp.getWriter();
        printWriter.write(employees.toString());
    }
}
