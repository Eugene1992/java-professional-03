package com.cbu.edu.JDBC.Model;

/**
 * Created by Sviatoslav on 10.03.2017.
 */
public abstract class IdEntity {
    protected Integer id;

    public IdEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
