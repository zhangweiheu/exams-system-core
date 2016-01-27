package com.online.exams.system.core.mongo;

import com.online.exams.system.core.util.Page;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * Created by 36kr on 16/1/25.
 */
public interface MongoBaseDAO<T> {

    void insertRecord(T record);

    void deleteByCondition(Query example);

    void updateByCondition(Query query, Update update);

    List<T> selectByCondition(Query query);

    Page<T> findRecordByPage(Page<T> page, Query query);

    long countByCondition(Query query);
}
