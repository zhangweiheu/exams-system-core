package com.online.exams.system.core.dao.impl;

import com.online.exams.system.core.bean.MongoPaper;
import com.online.exams.system.core.bean.MongoPrimaryKey;
import com.online.exams.system.core.bean.Page;
import com.online.exams.system.core.constants.Constants;
import com.online.exams.system.core.dao.MongoPaperDao;
import com.online.exams.system.core.mongo.impl.MongoBaseDaoImplr;
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


/**
 * Created by zhang on 2016/3/12.
 */
@Repository
public class MongoPaperDaoImpl extends MongoBaseDaoImplr implements MongoPaperDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoPaperDaoImpl.class);

    @Override
    public Long addPaper(MongoPaper mongoPaper) {
        Long incId = getAutoIncrementId(Constants.mongo.test_case_primary_key);
        mongoPaper.setId(incId);
        mongoPaper.setCreateAt(new Date());
        mongoPaper.setUpdateAt(new Date());
        insert(mongoPaper);
        return mongoPaper.getId();
    }

    @Override
    public Page<MongoPaper> findMongoPaperPager(int pageIdx, int pageSize, MongoPaper mongoPaper, Date startDate, Date endDate) {
        Page<MongoPaper> pageMongoPaper = new Page<MongoPaper>();
        pageMongoPaper.setPage(pageIdx);
        pageMongoPaper.setPageSize(pageSize);

        Query query = bulidMongoPaperQuery(mongoPaper, startDate, endDate);
        // 排序方式
        Map<String, SortOrderType> sortMap = new HashMap<>();
        sortMap.put("createAt", SortOrderType.DESC);
        MongoSortBuilder.orderBy(query, sortMap);
        return findByPage(pageMongoPaper, query);
    }

    @Override
    public MongoPaper findMongoPaperById(Long id) {
        Query query = Query.query(Criteria.where("_id").is(id));
        List<MongoPaper> mongoPapers= mongoTemplate.find(query, MongoPaper.class);
        return null == mongoPapers ? null : mongoPapers.get(0);
    }

    @Override
    public Long updateMongoPaper(MongoPaper mongoPaper) {
        MongoQueryBuilder builder = new MongoQueryBuilder();

        MongoPaper _mongoPaper = new MongoPaper();
        _mongoPaper.setId(mongoPaper.getId());
        _mongoPaper.setUserId(mongoPaper.getUserId());
        builder.buildEqualsQuery(_mongoPaper);
        Query query = builder.getBaseQuery();

        Update updateVal = new Update();
        updateVal.set("questionMapList", mongoPaper.getQuestionMapList());
        updateVal.set("updateAt", new Date());
        mongoTemplate.updateMulti(query,updateVal,MongoPaper.class);
        return mongoPaper.getId();
    }

    public Long getAutoIncrementId(String serialKey) {
        Query query = Query.query(Criteria.where("_id").is(serialKey));
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

    private Query bulidMongoPaperQuery(MongoPaper mongoPaper, Date startDate, Date endDate) {
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

        builder.buildEqualsQuery(mongoPaper);
        return builder.getBaseQuery();
    }

}
