package com.cbu.edu.JDBC;

import com.cbu.edu.JDBC.DAO.EmployeeDAOImpl;
import com.cbu.edu.JDBC.DAO.IEmployeeDAO;
import com.cbu.edu.JDBC.Model.Employee;

/**
 * Created by Sviatoslav on 10.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        IEmployeeDAO<Employee, Integer> employeeDAO = new EmployeeDAOImpl();
        //employeeDAO.create();
        System.out.println(employeeDAO.read(2));
        //System.out.println(employeeDAO.readAll());
    }
}
