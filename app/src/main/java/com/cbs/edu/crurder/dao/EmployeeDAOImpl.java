package com.cbs.edu.crurder.dao;

import com.cbs.edu.crurder.connection.ConnectionFactory;
import com.cbs.edu.crurder.model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements GeneralDAO<Employee, Integer> {

    @Override
    public Employee create(Employee employee) {
        return null;
    }

    @Override
    public Employee read(Integer integer) {
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employees = new ArrayList<>();
        Connection connection;
        try {
            connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM employee;";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                int salary = rs.getInt("salary");
                LocalDate hireDate = rs.getDate("hiredate").toLocalDate();
                Employee employee = new Employee(id, firstName, lastName, age, salary, hireDate);
                employees.add(employee);
            }
            rs.close();
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
}
