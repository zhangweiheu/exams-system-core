package com.online.exams.system.core.service.impl;

import com.online.exams.system.core.dao.PaperDao;
import com.online.exams.system.core.model.Paper;
import com.online.exams.system.core.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangwei on 16/1/25.
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    PaperDao paperDao;

    @Override
    public List<Paper> listAllPaper(int offset, int pageSize) {
        return paperDao.listAllPaper(offset, pageSize);
    }

    @Override
    public List<Paper> listAllPaper(int offset, int pageSize, int uid) {
        return paperDao.listAllPaper(offset, pageSize, uid);
    }

    @Override
    public int updatePaper(Paper paper) {
        return paperDao.updatePaper(paper);
    }

    @Override
    public int deletePaperById(int pid) {
        return paperDao.deleteById(pid);
    }

    @Override
    public int deletePaperByAttr(Paper paper) {
        return paperDao.deletePaperByAttr(paper);

    }

    @Override
    public int savePaper(Paper paper) {
        return paperDao.savePaper(paper);
    }

    @Override
    public Paper findPaperById(int pid) {
        return paperDao.findById(pid);
    }

    @Override
    public int countAllPapersByAttr(Paper paper) {
        return paperDao.countAllPapersByAttr(paper);
    }

    @Override
    public Paper findDoingPaperBy(int uid) {
        return paperDao.findDoingPaperBy(uid);
    }
}
