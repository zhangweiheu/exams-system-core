package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.dao.QuestionBankDao;
import com.online.exams.system.core.mapper.QuestionBankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhang on 2016/2/15.
 */
@Repository
public class QuestionBankDaoImpl implements QuestionBankDao {
    @Autowired
    QuestionBankMapper questionBankMapper;

    @Override
    public Object findById(int qid) {
        return questionBankMapper.selectById(qid);
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public int deleteById(int qid) {
        return questionBankMapper.deleteById(qid);
    }
}
