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
        String query = "INSERT INTO Employee(full_name, age, address)" +
                "VALUES ('Piotr', 28, 'Koszarowa')";
        boolean checkCreate = false;
        try (Connection connection = MyConnection.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
            checkCreate = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkCreate;
    }

    @Override
    public Employee read(Integer index) {
        String query = "SELECT * FROM Employee Where Employee.id = " + index;
        ResultSet result;
        try (Connection connection = MyConnection.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            result = statement.executeQuery();
            while (result.next()) {
                if (result.getInt("id") == index) {
                    int id = result.getInt("id");
                    String name = result.getString("full_name");
                    int age = result.getInt("age");
                    String address = result.getString("address");
                    return new Employee(id, name, age, address);
                }
            }
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    @Override
    public void update(Integer index) {
        String query = "UPDATE Employee "
                + "SET full_name = 'Greg' , age = 20, address = 'Sieroca'"
                + "WHERE id =" + index;
        try (Connection connection = MyConnection.getConnect();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void delete(Integer index) {
        String query = "DELETE FROM Employee WHERE id = " + index;
        try(Connection connection = MyConnection.getConnect();
            PreparedStatement statement = connection.prepareStatement(query)){
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public List<Employee> readAll() {
        String query = "SELECT * FROM Employee";
        List<Employee> employees = new ArrayList<>();
        try(Connection connection = MyConnection.getConnect();
            PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String firstName = result.getString("full_name");
                int age = result.getInt("age");
                String address = result.getString("address");
                Employee employee = new Employee(id, firstName, age, address);
                employees.add(employee);
            }
            connection.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
}
