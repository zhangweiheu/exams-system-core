package com.online.exams.system.core.service;

import com.online.exams.system.core.model.Paper;

import java.util.List;

/**
 * Created by 36kr on 16/1/25.
 */

public interface PaperService {
    List<Paper> listAllPaper();

    int updatePaper(Paper paper, String tagList);

    int deletePaperById(int pid);

    int deletePaperByAttr(Paper paper);

    int savePaper(Paper paper, String tagList);
}
