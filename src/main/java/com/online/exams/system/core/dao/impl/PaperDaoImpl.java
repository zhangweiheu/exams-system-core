package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.dao.PaperDao;
import com.online.exams.system.core.mapper.PaperMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 36kr on 16/1/25.
 */
@Repository
@EnableMongoRepositories
public class PaperDaoImpl implements PaperDao {
    @Autowired
    PaperMapper paperMapper;

    @Override
    public Object findById(int pid) {
        return paperMapper.selectById(pid);
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public int deleteById(int pid) {
        return paperMapper.deleteById(pid);
    }
}
