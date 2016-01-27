package com.online.exams.system.core.util.mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Map;
import java.util.Set;

/**
 * Created by Vincent on 2015/5/22.
 * brief desc : mongo Query对象的调用统一封装
 */
public class MongoSortBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoSortBuilder.class);

    /**
     * 构造排序
     **/
    public static void orderBy(Query query, Map<String, SortOrderType> sortMap) {
        if (sortMap != null && sortMap.size() > 0) {
            Set<String> sortOrderTypes = sortMap.keySet();
            for (String sortField : sortOrderTypes) {
                SortOrderType sortOrderType = sortMap.get(sortField);
                query.with(new Sort(sortOrderType == SortOrderType.ASC ? Sort.Direction.ASC : Sort.Direction.DESC, sortField));
            }
        }
    }

}
