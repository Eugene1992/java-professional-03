package com.cbs.edu.crurder.dao;

import com.cbs.edu.crurder.model.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface GeneralDAO<T extends BaseEntity, ID extends Serializable> {

    T create();

    T read(ID id);

    T update(ID id);

    void delete(ID id);

    List<T> readAll();
}
