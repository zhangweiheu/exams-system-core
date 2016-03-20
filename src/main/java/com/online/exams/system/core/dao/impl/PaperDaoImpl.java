package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.dao.PaperDao;
import com.online.exams.system.core.enums.StatusEnum;
import com.online.exams.system.core.mapper.PaperMapper;
import com.online.exams.system.core.model.Paper;
import com.online.exams.system.core.model.PaperCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 36kr on 16/1/25.
 */
@Repository
public class PaperDaoImpl implements PaperDao {
    @Autowired
    PaperMapper paperMapper;

    @Override
    public Paper findById(int pid) {
        return paperMapper.selectById(pid);
    }

    @Override
    public List<Paper> findAll() {
        return paperMapper.selectByCondition(convertPaperAttr2Condition(null));
    }

    @Override
    public int deleteById(int pid) {
        Paper paper = new Paper();
        paper.setStatus(StatusEnum.DELETE);
        paper.setId(pid);
        return paperMapper.updateByIdSelective(paper);
    }

    @Override
    public int updatePaper(Paper paper) {
        return paperMapper.updateByIdSelective(paper);
    }

    @Override
    public int deletePaperByAttr(Paper paper) {
        paper.setStatus(StatusEnum.DELETE);
        return paperMapper.updateByIdSelective(paper);
    }

    @Override
    public int savePaper(Paper paper) {
        return paperMapper.insertSelective(paper);
    }

    @Override
    public List<Paper> listAllPaper(int offset, int pageSize) {
        PaperCondition condition = new PaperCondition();
        condition.setLimitOffset(offset);
        condition.setLimitSize(pageSize);
        return paperMapper.selectByCondition(condition);
    }

    @Override
    public List<Paper> listAllPaper(int offset, int pageSize, int uid) {
        PaperCondition condition = new PaperCondition();
        condition.setLimitOffset(offset);
        condition.setLimitSize(pageSize);
        condition.createCriteria().andUserIdEqualTo(uid);
        return paperMapper.selectByCondition(condition);
    }

    @Override
    public int countAllPapersByAttr(Paper paper) {
        return paperMapper.countByCondition(convertPaperAttr2Condition(paper));
    }

    @Override
    public Paper findDoingPaperByUid(int uid) {
        PaperCondition condition = new PaperCondition();
        condition.createCriteria().andUserIdEqualTo(uid).andStatusEqualTo(StatusEnum.NORMAL);
        List<Paper> list = paperMapper.selectByCondition(condition);
        return 0 == list.size()? null :list.get(0);
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
        if (null != paper.getMongoPaperId()) {
            condition.createCriteria().andMongoPaperIdEqualTo(paper.getMongoPaperId());
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

        return condition;
    }
}
