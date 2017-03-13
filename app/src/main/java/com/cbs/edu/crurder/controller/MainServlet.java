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
        printWriter.write("<table style=\"border: 1px solid black\">");
        printWriter.write("<tr>");
        printWriter.write("<td>First name</td>");
        printWriter.write("<td>Last name</td>");
        printWriter.write("<td>Age</td>");
        printWriter.write("<td>Salary</td>");
        printWriter.write("<td>Hire date</td>");
        printWriter.write("</tr>");

        for (Employee employee : employees) {
            printWriter.write("<tr>");
            printWriter.write("<td>" + employee.getFirstName() + "</td>");
            printWriter.write("<td>" + employee.getLastName() + "</td>");
            printWriter.write("<td>" + employee.getAge() + "</td>");
            printWriter.write("<td>" + employee.getSalary() + "</td>");
            printWriter.write("<td>" + employee.getHiredate() + "</td>");
            printWriter.write("</tr>");
        }

        printWriter.write("</table>");
    }
}
