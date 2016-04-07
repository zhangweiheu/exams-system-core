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
    public List<Paper> findAll(int offset, int pageSize) {
        PaperCondition paperCondition = convertPaperAttr2Condition(null);
        paperCondition.setLimitOffset(offset);
        paperCondition.setLimitSize(pageSize);
        return paperMapper.selectByCondition(paperCondition);
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
        return 0 == list.size() ? null : list.get(0);
    }

    @Override
    public List<Paper> findAllDonePaperByUid(int uid) {
        PaperCondition condition = new PaperCondition();
        condition.setOrderByClause("update_at");
        condition.createCriteria().andUserIdEqualTo(uid).andStatusEqualTo(StatusEnum.CLOSE);
        return paperMapper.selectByCondition(condition);
    }

    private PaperCondition convertPaperAttr2Condition(Paper paper) {
        PaperCondition condition = new PaperCondition();

        PaperCondition.Criteria criteria = condition.createCriteria();

        if (null == paper) {
            return condition;
        }

        if (null != paper.getId()) {
            criteria.andIdEqualTo(paper.getId());
        }
        if (null != paper.getUserId()) {
            criteria.andUserIdEqualTo(paper.getUserId());
        }
        if (null != paper.getMongoPaperId()) {
            criteria.andMongoPaperIdEqualTo(paper.getMongoPaperId());
        }
        if (null != paper.getPaperType()) {
            criteria.andPaperTypeEqualTo(paper.getPaperType());
        }
        if (null != paper.getDifficulty()) {
            criteria.andDifficultyEqualTo(paper.getDifficulty());
        }
        if (null != paper.getTotalPoints()) {
            criteria.andTotalPointsEqualTo(paper.getTotalPoints());
        }
        if (null != paper.getScore()) {
            criteria.andScoreEqualTo(paper.getScore());
        }
        if (null != paper.getStatus()) {
            criteria.andStatusEqualTo(paper.getStatus());
        }
        condition.or(criteria);
        return condition;
    }
}
