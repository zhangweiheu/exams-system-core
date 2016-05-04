package com.online.exams.system.core.service;

import com.online.exams.system.core.mybatis.enums.TagEnum;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhang on 2016/3/12.
 */
public interface PaperGenerateService {
    HashMap<String, Object> generateSingleSelection(List<TagEnum> tagEnumList, int uid);

    HashMap<String, Object> generateMultiSelection(List<TagEnum> tagEnumList, int uid);

    HashMap<String, Object> generateProgrammingQuestion(List<TagEnum> tagEnumList, int uid);

    HashMap<String, Object> generateSingleMultiSelection(List<TagEnum> tagEnumList, int uid);

    HashMap<String, Object> generateMultiProgrammingSelection(List<TagEnum> tagEnumList, int uid);

    HashMap<String, Object> generateSingleProgrammingQuestion(List<TagEnum> tagEnumList, int uid);

    HashMap<String, Object> generateSingleMultiProgrammingQuestion(List<TagEnum> tagEnumList, int uid);



}
