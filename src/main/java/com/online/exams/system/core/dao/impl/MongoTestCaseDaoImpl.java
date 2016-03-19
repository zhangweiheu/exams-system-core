package com.online.exams.system.core.dao.impl;

import com.mongodb.DBObject;
import com.online.exams.system.core.bean.MongoPrimaryKey;
import com.online.exams.system.core.bean.Page;
import com.online.exams.system.core.bean.TestCase;
import com.online.exams.system.core.constants.Constants;
import com.online.exams.system.core.dao.MongoTestCaseDao;
import com.online.exams.system.core.mongo.impl.MongoBaseDaoImpl;
import com.online.exams.system.core.util.mongo.MongoCompareQueryEnum;
import com.online.exams.system.core.util.mongo.MongoQueryBuilder;
import com.online.exams.system.core.util.mongo.MongoSortBuilder;
import com.online.exams.system.core.util.mongo.SortOrderType;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

/**
 * Created by zhang on 2016/3/12.
 */
@Repository
public class MongoTestCaseDaoImpl extends MongoBaseDaoImpl implements MongoTestCaseDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoTestCaseDaoImpl.class);

    @Override
    public long addTestCase(TestCase testCase) {
        Long incId = getAutoIncrementId(Constants.mongo.test_case_primary_key);
        testCase.setId(incId);
        testCase.setCreateAt(new Date());
        testCase.setUpdateAt(new Date());
        insert(testCase);
        return testCase.getId();
    }

    @Override
    public Page<TestCase> findTestCasePager(int pageIdx, int pageSize, TestCase testCase, Date startDate, Date endDate) {
        Page<TestCase> pageTestCase = new Page<TestCase>();
        pageTestCase.setPage(pageIdx);
        pageTestCase.setPageSize(pageSize);

        Query query = bulidTestCaseQuery(testCase, startDate, endDate);
        // 排序方式
        Map<String, SortOrderType> sortMap = new HashMap<>();
        sortMap.put("send_time", SortOrderType.DESC);
        MongoSortBuilder.orderBy(query, sortMap);
        return findByPage(pageTestCase, query);
    }

    @Override
    public TestCase findTestCaseById(Long id) {
        TestCase testCase = new TestCase();
        testCase.setId(id);
        Query query = bulidTestCaseQuery(testCase, null, null);
        List<TestCase> testCaseList = mongoTemplate.find(query, TestCase.class);
        return CollectionUtils.isNotEmpty(testCaseList) ? testCaseList.get(0) : null;
    }

    public Long getAutoIncrementId(String serialKey) {
        Query query = query(where("_id").is(serialKey));
        //先查询是否存在  不存在初始化
        List<MongoPrimaryKey> keyList = mongoTemplate.find(query, MongoPrimaryKey.class);
        if (CollectionUtils.isEmpty(keyList)) {
            MongoPrimaryKey initVal = new MongoPrimaryKey();
            initVal.setSerialKey(serialKey);
            initVal.setSerialValue(0l);
            mongoTemplate.insert(initVal);
        }

        //自增操作
        Update update = new Update().inc("serialValue", 1);
        FindAndModifyOptions options = FindAndModifyOptions.options().returnNew(true);
        MongoPrimaryKey mongoPrimaryKey = mongoTemplate.findAndModify(query, update, options, MongoPrimaryKey.class);
        if (mongoPrimaryKey == null) {
            throw new RuntimeException("MongDB primary key Generator error by field --->" + serialKey);
        }
        return mongoPrimaryKey.getSerialValue();
    }

    @Override
    public long updateTestCaseByTCID(TestCase testCase) {
        mongoTemplate.updateFirst(query(where("_id").is(testCase.getId())),update("keyValue", testCase.getKeyValue()) , TestCase.class);
        mongoTemplate.updateFirst(query(where("_id").is(testCase.getId())),update("updateAt", new Date()) , TestCase.class);
        List<TestCase> testCaseList = mongoTemplate.find(query(where("_id").is(testCase.getId())),TestCase.class);
        return CollectionUtils.isNotEmpty(testCaseList) ? testCaseList.get(0).getId() : null;
    }

    private Query bulidTestCaseQuery(TestCase testCase, Date startDate, Date endDate) {
        MongoQueryBuilder builder = new MongoQueryBuilder();
        if (null != startDate) {
            Map<String, Object> gteMap = new HashMap<>();
            gteMap.put("createAt", startDate);
            builder.buildCompareQuery(MongoCompareQueryEnum.GTE, gteMap);
        }
        if (null != endDate) {
            Map<String, Object> gteMap = new HashMap<>();
            gteMap.put("createAt", new Date());
            builder.buildCompareQuery(MongoCompareQueryEnum.LTE, gteMap);
        }

        builder.buildEqualsQuery(testCase);
        return builder.getBaseQuery();
    }

}
