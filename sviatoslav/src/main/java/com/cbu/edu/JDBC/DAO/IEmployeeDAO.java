package com.cbu.edu.JDBC.DAO;

import com.cbu.edu.JDBC.Model.Employee;
import com.cbu.edu.JDBC.Model.IdEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sviatoslav on 10.03.2017.
 */
public interface IEmployeeDAO<T extends IdEntity, ID extends Serializable> {
    boolean create();

    T read(ID id);

    T update(ID id);

    T delete(ID id);

    List<T> readAll();
}
