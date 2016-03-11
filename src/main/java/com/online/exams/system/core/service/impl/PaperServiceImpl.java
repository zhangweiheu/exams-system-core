package com.online.exams.system.core.service.impl;

import com.online.exams.system.core.dao.PaperDao;
import com.online.exams.system.core.enums.RefTypeEnum;
import com.online.exams.system.core.enums.TagEnum;
import com.online.exams.system.core.model.Paper;
import com.online.exams.system.core.model.Tag;
import com.online.exams.system.core.service.PaperService;
import com.online.exams.system.core.service.TagService;
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

    @Autowired
    TagService tagService;

    @Override
    public List<Paper> listAllPaper() {
        return paperDao.findAll();
    }

    @Override
    public int updatePaper(Paper paper, String tagList) {
        int i = paperDao.updatePaper(paper);
        updatePaperTagEnum(tagList, paper.getId());
        return i;
    }

    @Override
    public int deletePaperById(int pid) {
        int i = paperDao.deleteById(pid);
        updatePaperTagEnum(null, pid);
        return i;
    }

    @Override
    public int deletePaperByAttr(Paper paper) {
        int i = paperDao.deletePaperByAttr(paper);
        updatePaperTagEnum(null, paper.getId());
        return i;
    }

    @Override
    public int savePaper(Paper paper, String tagList) {
        int i = paperDao.savePaper(paper);
        updatePaperTagEnum(tagList, paper.getId());
        return i;
    }

    private int updatePaperTagEnum(String enumList, int pid) {
        Tag tag = new Tag();
        tag.setRefId(pid);
        tag.setRefType(RefTypeEnum.PAPER);
        tagService.deleteTagByTagAttr(tag);
        if (null != enumList) {
            char[] chars = enumList.toCharArray();
            for (char c : chars) {
                tag.setTagValue(TagEnum.parse(c - 48));
                tagService.saveTag(tag);
            }
        } else {
            return 0;
        }
        return enumList.length();
    }
}
