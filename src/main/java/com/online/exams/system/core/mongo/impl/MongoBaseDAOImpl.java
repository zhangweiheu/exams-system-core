package com.online.exams.system.core.mongo.impl;

import com.online.exams.system.core.bean.Page;
import com.online.exams.system.core.mongo.MongoBaseDAO;
import com.online.exams.system.core.util.mongo.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by zhangwei on 16/1/25.
 */
@Repository
public class MongoBaseDAOImpl<T> implements MongoBaseDAO<T> {

    @Autowired
    @Qualifier(value = "mongoTemplate")
    protected MongoTemplate mongoTemplate;

    public void insertRecord(T record) {
        mongoTemplate.insert(record);
    }

    public void deleteByCondition(Query example) {
        mongoTemplate.remove(example, getEntityClass());
    }

    public void updateByCondition(Query query, Update update) {
        mongoTemplate.updateMulti(query, update, getEntityClass());
    }

    public List<T> selectByCondition(Query query) {
        return mongoTemplate.find(query, getEntityClass());
    }

    public Page<T> findRecordByPage(Page<T> page, Query query) {
        int count = (int) countByCondition(query);
        int pageSize = page.getPageSize();
        page.setTotalCount(count);
        if (count > 0) {
            query.skip((page.getPage() - 1) * pageSize).limit(pageSize);
            List<T> rows = this.selectByCondition(query);
            page.setData(rows);
        }
        return page;
    }

    public long countByCondition(Query query) {
        return mongoTemplate.count(query, getEntityClass());
    }

    /**
     * 获取需要操作的实体类class
     *
     * @return
     */
    private Class<T> getEntityClass() {
        return ReflectionUtils.getSuperClassGenricType(getClass());
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }
}
