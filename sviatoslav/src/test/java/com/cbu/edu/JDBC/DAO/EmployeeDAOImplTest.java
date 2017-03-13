package com.cbu.edu.JDBC.DAO;

import com.cbu.edu.JDBC.Model.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Sviatoslav on 10.03.2017.
 */
public class EmployeeDAOImplTest {
    private EmployeeDAOImpl employeeDAO;
    List<Employee> employeeList;

    @Before
    public void setUp() throws Exception {
        employeeDAO = new EmployeeDAOImpl();
        employeeList = new ArrayList<>();
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
        employeeList = employeeDAO.readAll();
        final int EXPECTED_RESULT = 1;
        assertEquals(employeeList.size(), EXPECTED_RESULT);
    }

}