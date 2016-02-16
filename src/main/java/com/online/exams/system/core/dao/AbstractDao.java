package com.online.exams.system.core.dao;

import java.util.List;

/**
 * Created by zhang on 2016/2/9.
 */
public interface AbstractDao<T> {
    T findById(int id);

    List<T> findAll();

    int deleteById(int id);
}
