package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.dao.PaperDao;
import com.online.exams.system.core.mapper.PaperMapper;
import com.online.exams.system.core.model.Paper;
import com.online.exams.system.core.model.PaperCondition;
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
        return paperMapper.selectByCondition(convertPaperAttr2Condition(null));
    }

    @Override
    public int deleteById(int pid) {
        return paperMapper.deleteById(pid);
    }

    @Override
    public int updatePaper(Paper paper) {
        return paperMapper.updateByIdSelective(paper);
    }

    @Override
    public int deletePaperByAttr(Paper paper) {
        return paperMapper.deleteByCondition(convertPaperAttr2Condition(paper));
    }

    @Override
    public int savePaper(Paper paper) {
        return paperMapper.insertSelective(paper);
    }

    private PaperCondition convertPaperAttr2Condition(Paper paper) {
        PaperCondition condition = new PaperCondition();

        if (null == paper) {
            return condition;
        }
        if (null != paper.getId()) {
            condition.createCriteria().andIdEqualTo(paper.getId());
        }
        if (null != paper.getUserId()) {
            condition.createCriteria().andUserIdEqualTo(paper.getUserId());
        }
        if (null != paper.getPaperId()) {
            condition.createCriteria().andPaperIdEqualTo(paper.getPaperId());
        }
        if (null != paper.getPaperType()) {
            condition.createCriteria().andPaperTypeEqualTo(paper.getPaperType());
        }
        if (null != paper.getDifficulty()) {
            condition.createCriteria().andDifficultyEqualTo(paper.getDifficulty());
        }
        if (null != paper.getTotalPoints()) {
            condition.createCriteria().andTotalPointsEqualTo(paper.getTotalPoints());
        }
        if (null != paper.getScore()) {
            condition.createCriteria().andScoreEqualTo(paper.getScore());
        }
        if (null != paper.getStatus()) {
            condition.createCriteria().andStatusEqualTo(paper.getStatus());
        }
        if (null != paper.getIsDelete()) {
            condition.createCriteria().andIsDeleteEqualTo(paper.getIsDelete());
        }

        return condition;
    }
}
