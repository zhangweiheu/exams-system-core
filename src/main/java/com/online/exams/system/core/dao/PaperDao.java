package com.online.exams.system.core.dao;

import com.online.exams.system.core.model.Paper;

import java.util.List;

/**
 * Created by 36kr on 16/1/25.
 */
public interface PaperDao {
    int deleteById(int pid);

    Paper findById(int pid);

    List<Paper> findAll();

    int updatePaper(Paper paper);

    int deletePaperByAttr(Paper paper);

    int savePaper(Paper paper);

    List<Paper> listAllPaper(int offset, int pageSize);

    List<Paper> listAllPaper(int offset, int pageSize,int uid);

    int countAllPapersByAttr(Paper paper);

    Paper findDoingPaperBy(int uid);
}
