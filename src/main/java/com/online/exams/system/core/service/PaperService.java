package com.online.exams.system.core.service;

import com.online.exams.system.core.model.Paper;

import java.util.List;

/**
 * Created by 36kr on 16/1/25.
 */

public interface PaperService {
    List<Paper> listAllPaper(int offset, int pageSize);

    List<Paper> listAllPaper(int offset, int pageSize, int uid);

    int updatePaper(Paper paper);

    int deletePaperById(int pid);

    int deletePaperByAttr(Paper paper);

    int savePaper(Paper paper);

    Paper findPaperById(int pid);

    int countAllPapersByAttr(Paper paper);

    Paper findDoingPaperByUid(int uid);
}
