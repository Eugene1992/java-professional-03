package com.cbs.edu.crurder.dao;

import com.cbs.edu.crurder.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeDAOImplTest {

    private EmployeeDAOImpl employeeDAO;

    @Before
    public void setUp() {
        employeeDAO = new EmployeeDAOImpl();
    }

    @Test
    public void create() throws Exception {

    }

    @Test
    public void read() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void readAll() throws Exception {
        List<Employee> employees = employeeDAO.readAll();
        System.out.println(employees);
        final int expectedSize = 1;
        Assert.assertEquals(expectedSize, employees.size());
    }

}