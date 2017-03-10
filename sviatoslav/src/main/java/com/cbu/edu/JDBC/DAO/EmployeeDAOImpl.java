package com.cbu.edu.JDBC.DAO;

import com.cbu.edu.JDBC.Connect.MyConnection;
import com.cbu.edu.JDBC.Model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Sviatoslav on 10.03.2017.
 */
public class EmployeeDAOImpl implements IEmployeeDAO<Employee, Integer> {
    @Override
    public boolean create() {
        Connection connection;
        boolean checkCreate = false;
        try {
            connection = MyConnection.getConnect();
            String query = "INSERT INTO Employee(full_name, age, address)" +
                    "VALUES ('Piotr', 28, 'Koszarowa')";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            checkCreate = true;
            connection.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkCreate;
    }

    @Override
    public Employee read(Integer index) {
        Connection connection;
        try {
            String query = "SELECT * FROM Employee Where Employee.id = " + index;
            connection = MyConnection.getConnect();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                if (result.getInt("id") == index) {
                    int id = result.getInt("id");
                    String name = result.getString("full_name");
                    int age = result.getInt("age");
                    String address = result.getString("address");
                    return new Employee(id, name, age, address);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    @Override
    public Employee update(Integer integer) {
        return null;
    }

    @Override
    public Employee delete(Integer integer) {
        return null;
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employees = new ArrayList<>();
        Connection connection;
        try {
            String query = "SELECT * FROM Employee";
            connection = MyConnection.getConnect();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String firstName = result.getString("full_name");
                int age = result.getInt("age");
                String address = result.getString("address");
                Employee employee = new Employee(id, firstName, age, address);
                employees.add(employee);
            }
            statement.close();
            result.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
}
