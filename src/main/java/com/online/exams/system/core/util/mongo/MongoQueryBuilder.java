package com.online.exams.system.core.util.mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Vincent on 2015/5/22.
 * brief desc : mongo Query对象的调用统一封装
 */
public class MongoQueryBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoQueryBuilder.class);

    private Query baseQuery;
    private List<Criteria> criteriaList;

    /**
     * 统一出口
     *
     * @return
     */
    public Query getBaseQuery() {
        if (criteriaList.size() > 0) {
            Criteria c = new Criteria();
            Criteria[] cs = new Criteria[criteriaList.size()];
            c.andOperator(criteriaList.toArray(cs));
            baseQuery.addCriteria(c);
        }
        return baseQuery;
    }

    public List<Criteria> getBaseCriteriaList() {
        return criteriaList;
    }


    /**
     * 构造方法区
     *
     * @param query
     */
    public MongoQueryBuilder(Query query) {
        this.baseQuery = query;
    }

    public MongoQueryBuilder() {
        this.baseQuery = new Query();
        criteriaList = new ArrayList<Criteria>();
    }

    public void setBaseQuery(Query baseQuery) {
        this.baseQuery = baseQuery;
    }

    /**
     * 构造equals类型查询
     **/
    public MongoQueryBuilder buildEqualsQuery(Object queryCondition) {
        Map<String, Object> qryMap = transfromToMap(queryCondition);
        buildEqualsCriteria(qryMap, null);
        return this;
    }
    public MongoQueryBuilder buildNotEqualsQuery(Object queryCondition) {
        Map<String, Object> qryMap = transfromToMap(queryCondition);
        buildEqualsCriteria(null, qryMap);
        return this;
    }

    public MongoQueryBuilder buildRegexQuery(Map regexMap) {
        createCriteria(null, null, null, null, null, regexMap, null, null);
        return this;
    }


    /**
     * 构造比较类型查询 大于 小于 大于等于 小于等于
     **/
    public MongoQueryBuilder buildCompareQuery(MongoCompareQueryEnum compareEnum, Map<String, Object> compareMap) {
        switch (compareEnum) {
            case GT:
                buildCompareCriteria(compareMap, null, null, null);
                break;
            case LT:
                buildCompareCriteria(null, compareMap, null, null);
                break;
            case GTE:
                buildCompareCriteria(null, null, compareMap, null);
                break;
            case LTE:
                buildCompareCriteria(null, null, null, compareMap);
                break;
        }
        return this;
    }

    /**
     * 构造区域范围类型查询
     **/
    public MongoQueryBuilder buildRangeQuery(Map<String, Collection> qryMap) {
        buildRangeCriteria(qryMap);
        return this;
    }


    private void buildEqualsCriteria(Map<String, Object> eqMap, Map<String, Object> neMap) {
        createCriteria(null, null, eqMap, null, null, null, null, neMap);
    }


    private void buildCompareCriteria(Map<String, Object> gtMap, Map<String, Object> ltMap, Map<String, Object> gteMap, Map<String, Object> lteMap) {
        createCriteria(gtMap, ltMap, null, gteMap, lteMap, null, null, null);
    }


    private void buildRangeCriteria(Map<String, Collection> inMap) {
        createCriteria(null, null, null, null, null, null, inMap, null);
    }


    /**
     * 生产查询语句
     *
     * @param gtMap
     * @param ltMap
     * @param eqMap
     * @param gteMap
     * @param lteMap
     * @param regexMap
     * @param inMap
     * @param neMap
     * @return Criteria 查询的语句
     * @throws
     * @Title: createCriteria
     * @Description: 根据不同条件生产SQL
     */
    @SuppressWarnings("rawtypes")
    private void createCriteria(Map<String, Object> gtMap,
                                Map<String, Object> ltMap,
                                Map<String, Object> eqMap,
                                Map<String, Object> gteMap,
                                Map<String, Object> lteMap,
                                Map<String, String> regexMap,
                                Map<String, Collection> inMap,
                                Map<String, Object> neMap) {

        Set<String> _set = null;
        if (gtMap != null && gtMap.size() > 0) {
            _set = gtMap.keySet();
            for (String _s : _set) {
                criteriaList.add(Criteria.where(_s).gt(gtMap.get(_s)));
            }
        }
        if (ltMap != null && ltMap.size() > 0) {
            _set = ltMap.keySet();
            for (String _s : _set) {
                criteriaList.add(Criteria.where(_s).lt(ltMap.get(_s)));
            }
        }
        if (eqMap != null && eqMap.size() > 0) {
            _set = eqMap.keySet();
            for (String _s : _set) {
                criteriaList.add(Criteria.where(_s).is(eqMap.get(_s)));
            }
        }
        if (gteMap != null && gteMap.size() > 0) {
            _set = gteMap.keySet();
            for (String _s : _set) {
                criteriaList.add(Criteria.where(_s).gte(gteMap.get(_s)));
            }
        }
        if (lteMap != null && lteMap.size() > 0) {
            _set = lteMap.keySet();
            for (String _s : _set) {
                criteriaList.add(Criteria.where(_s).lte(lteMap.get(_s)));
            }
        }

        if (regexMap != null && regexMap.size() > 0) {
            _set = regexMap.keySet();
            for (String _s : _set) {
                criteriaList.add(Criteria.where(_s).regex(regexMap.get(_s)));
            }
        }

        if (inMap != null && inMap.size() > 0) {
            _set = inMap.keySet();
            for (String _s : _set) {
                criteriaList.add(Criteria.where(_s).in(inMap.get(_s)));
            }
        }
        if (neMap != null && neMap.size() > 0) {
            _set = neMap.keySet();
            for (String _s : _set) {
                criteriaList.add(Criteria.where(_s).ne(neMap.get(_s)));
            }
        }

    }


    /**
     * map转换  utils
     * @param bean
     * @return
     */
    public static Map<String, Object> transfromToMap(Object bean) {
        if (null == bean) return null;
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            if (null == propertyDescriptors) {
                return null;
            }
            for (PropertyDescriptor property : propertyDescriptors) {
                String propertyName = property.getName();
                if (propertyName.equals("class")) {
                    continue;
                }
                Method getMethod = property.getReadMethod();
                Object value = getMethod.invoke(bean);
                if (null == value)
                    continue;
                map.put(propertyName, value);
            }
        } catch (Exception e) {
            LOGGER.warn("转换bean to map失败", e);
        }
        return map;
    }

}
