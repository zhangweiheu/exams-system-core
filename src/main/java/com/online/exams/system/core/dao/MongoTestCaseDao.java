package com.online.exams.system.core.dao;

import com.online.exams.system.core.bean.Page;
import com.online.exams.system.core.bean.TestCase;

import java.util.Date;

/**
 * Created by zhang on 2016/3/12.
 */
public interface MongoTestCaseDao {
    long addTestCase(TestCase testCase);

    Page<TestCase> findTestCasePager(int pageIdx, int pageSize, TestCase testCase, Date startDate, Date endDate);

    TestCase findTestCaseById(Long id);

    long updateTestCaseByTCID(TestCase testCase);
}
