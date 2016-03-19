/**
 *
 */
package com.online.exams.system.core.util;

import com.online.exams.system.core.enums.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tanxianwen 2015年1月26日
 */
public abstract class DictUtil {

    public static Map<String, Class<? extends Enum<?>>> getDictEnumClasses() {
        Map<String, Class<? extends Enum<?>>> map = new LinkedHashMap<String, Class<? extends Enum<?>>>();
        put(QuestionTypeEnum.class, map);
        put(TagEnum.class, map);
        put(StatusEnum.class, map);
        put(PaperTypeEnum.class, map);
        put(RefTypeEnum.class, map);
        return map;
    }

    private static void put(Class<? extends Enum<?>> clazz, Map<String, Class<? extends Enum<?>>> map) {
        map.put(clazz.getSimpleName(), clazz);
    }

}
