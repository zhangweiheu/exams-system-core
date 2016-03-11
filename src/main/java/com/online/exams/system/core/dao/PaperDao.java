package com.online.exams.system.core.dao;

import com.online.exams.system.core.model.Paper;

/**
 * Created by 36kr on 16/1/25.
 */
public interface PaperDao extends AbstractDao {
    int updatePaper(Paper paper);

    int deletePaperByAttr(Paper paper);

    int savePaper(Paper paper);
}
