package com.online.exams.system.core.dao;

import com.online.exams.system.core.bean.MongoPaper;
import com.online.exams.system.core.bean.Page;

import java.util.Date;

/**
 * Created by zhang on 2016/3/12.
 */
public interface MongoPaperDao {

    Long addPaper(MongoPaper mongoPaper);

    Page<MongoPaper> findMongoPaperPager(int pageIdx, int pageSize, MongoPaper mongoPaper, Date startDate, Date endDate);

    MongoPaper findMongoPaperById(Long id);

    Long updateMongoPaper(MongoPaper mongoPaper);
}
