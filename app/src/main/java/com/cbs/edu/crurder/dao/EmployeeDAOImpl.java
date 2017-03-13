package com.cbs.edu.crurder.dao;

import com.cbs.edu.crurder.connection.ConnectionFactory;
import com.cbs.edu.crurder.model.Employee;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements GeneralDAO<Employee, Integer> {

    @Override
    public Employee create(Employee employee) {
        String sql = "INSERT INTO employee(first_name, last_name, age, salary, hiredate) VALUES (?, ?, ?, ?, ?)";
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setInt(3, employee.getAge());
            statement.setInt(4, employee.getSalary());
            statement.setDate(5, Date.valueOf(employee.getHiredate()));
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public Employee read(Integer id) {
        String sql = "SELECT * FROM employee WHERE id=?";
        Connection connection = ConnectionFactory.getConnection();
        Employee employee = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int empId = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int age = rs.getInt("age");
                int salary = rs.getInt("salary");
                LocalDate hireDate = rs.getDate("hiredate").toLocalDate();
                employee = new Employee(id, firstName, lastName, age, salary, hireDate);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        String sql = "UPDATE employee SET first_name=?, last_name=?, age=?, salary=?, hiredate=? WHERE id=?";
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setInt(3, employee.getAge());
            statement.setInt(4, employee.getSalary());
            statement.setDate(5, Date.valueOf(employee.getHiredate()));
            statement.setInt(6, employee.getId());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM employee WHERE id=?";
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
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
