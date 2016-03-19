package com.online.exams.system.core.mongo;

import com.online.exams.system.core.bean.Page;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * Created by 36kr on 16/1/25.
 */
public interface MongoBaseDao<T> {

    void insert(T record);

    void deleteByCondition(Query query);

    void updateByCondition(Query query, Update update);

    List<T> selectByCondition(Query query);

    Page<T> findByPage(Page<T> page, Query query);

    long countByCondition(Query query);
}
