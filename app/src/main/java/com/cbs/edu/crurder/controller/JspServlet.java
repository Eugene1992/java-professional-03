package com.cbs.edu.crurder.controller;

import com.cbs.edu.crurder.dao.EmployeeDAOImpl;
import com.cbs.edu.crurder.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class JspServlet extends HttpServlet {

    private EmployeeDAOImpl employeeDAO;

    @Override
    public void init() throws ServletException {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null) {
            int id = Integer.parseInt(req.getParameter("id"));
            switch (action) {
                case "delete":
                    employeeDAO.delete(id);
                    resp.sendRedirect("/employees");
                    break;

                case "update":
                    Employee updEmployee = employeeDAO.read(id);
                    employeeDAO.update(updEmployee);
                    req.setAttribute("updEmployee", updEmployee);
                    req.setAttribute("employees", employeeDAO.readAll());
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("employees", employeeDAO.readAll());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = req.getParameter("id").isEmpty() ? 0 : Integer.parseInt(req.getParameter("id"));

        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        LocalDate hireDate = LocalDate.parse(req.getParameter("hiredate"));
        int salary = Integer.parseInt(req.getParameter("salary"));
        int age = Integer.parseInt(req.getParameter("age"));

        if (id == 0) {
            employeeDAO.create(new Employee(firstName, lastName, age, salary, hireDate));
        } else {
            employeeDAO.update(new Employee(id, firstName, lastName, age, salary, hireDate));
        }

        resp.sendRedirect("/employees");
    }
}
