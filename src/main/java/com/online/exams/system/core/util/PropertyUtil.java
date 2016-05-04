package com.online.exams.system.core.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Maps;
import com.online.exams.system.core.mybatis.IEnumValue;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * 提取参数 Created by quxiao on 15/1/26.
 */
public class PropertyUtil {

    public static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);

    /**
     * 提取参数对象的值
     *
     * @param obj
     * @return
     */
    public static Map<String, String> getPropertyMap(Object obj) {
        Map<String, Object> map;
        try {
            map = PropertyUtils.describe(obj);
        } catch (Exception e) {
            logger.info("getPropertyMap fail", e);
            map = null;
        }

        return distill(map);
    }

    // 去除值为空的属性, map中的class键
    private static Map<String, String> distill(Map<String, Object> propertyMap) {
        Map<String, String> map = null;
        String val = null;
        if (propertyMap != null && propertyMap.size() > 0) {
            map = Maps.newHashMap();

            for (Map.Entry<String, Object> entry : propertyMap.entrySet()) {
                Object value = entry.getValue();
                if (value == null) {
                    continue;
                }

                if ("class".equals(entry.getKey())) {
                    continue;
                }

                if (value instanceof String) {
                    val = StringUtils.trimToEmpty((String) value);
                } else if (value instanceof IEnumValue) {
                    val = String.valueOf(((IEnumValue) value).getValue());
                } else if (value instanceof JSONArray || value instanceof JSONObject) {
                    val =
                            StringUtils.trimToEmpty(JSON.toJSONString(value, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteNullStringAsEmpty,
                                    SerializerFeature.WriteNullListAsEmpty));
                } else if (value instanceof Date) {
                    val = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((Date) value);
                } else {
                    val = StringUtils.trimToEmpty(String.valueOf(value));
                }

                map.put(entry.getKey(), val);
            }
        }

        return map;
    }

}
