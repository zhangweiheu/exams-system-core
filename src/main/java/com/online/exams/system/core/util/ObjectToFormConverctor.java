package com.online.exams.system.core.util;

import com.online.exams.system.core.enums.mybatis.IEnumValue;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author huangteng
 */
public class ObjectToFormConverctor {

    /**
     * 转化的时候使用枚举值而不是枚举名
     */
    private boolean userEnumValue = true;

    /**
     * 如果为true，在转化的时候会将true转为1，false转为0
     */
    private boolean booleanToInteger = true;


    public void setUserEnumValue(boolean b) {
        userEnumValue = b;
    }
    public void setBooleanToInteger(boolean b) {
        booleanToInteger = b;
    }

    public ObjectToFormConverctor() {

    }

    public ObjectToFormConverctor(boolean userEnumValue, boolean booleanToInteger) {
        setUserEnumValue(userEnumValue);
        setBooleanToInteger(booleanToInteger);
    }

    /**
     * leaf object：该对象的类如果没有特殊的处理规则，这个对象会被调用toString方法同一处理。
     * @param o 被转化的对象
     * @param t 被转化对象的类
     */
    private void convertLeafObject(Object o, Class<?> t, ArrayList<String> l) {
        if (o == null)
            return;

        if(t.isEnum()) {
            if (this.userEnumValue) {
                if (o instanceof IEnumValue) {
                    l.add(String.valueOf(((IEnumValue) o).getValue()));
                } else {
                    l.add(String.valueOf(((Enum<?>) o).ordinal()));
                }
            } else {
                l.add(((Enum<?>)o).name());
            }
        } else if ((t.equals(boolean.class) || t.equals(Boolean.class)) && this.booleanToInteger) {
            Boolean b = (Boolean)o;
            if (b == true) {
                l.add(String.valueOf("1"));
            } else {
                l.add(String.valueOf("0"));
            }
        } else {
            l.add(o.toString());
        }
    }

    private void convertLeatObjectArray(Object[] ol, Class<?> t, ArrayList<String> l) {
        if (ol == null) {
            return;
        }

        for (int i = 0; i < ol.length; ++i) {
            convertLeafObject(ol[i], t, l);
        }
    }

    private void convertLeatPrimitiveArray(Object array, Class<?> t, ArrayList<String> l) {
        if (array == null)
            return;
        int length = Array.getLength(array);
        for (int i = 0; i < length; ++i) {
            Object o = Array.get(array, i);
            convertLeafObject(o, t, l);
        }
    }
    /**
     * 如果是一个对象，则遍历它的字段并put道map中
     */
    public MultiValueMap<String,String> convertObject(Object o) throws Exception {
        if (o == null)
            return null;

        MultiValueMap<String, String> retMap = new LinkedMultiValueMap<String, String>();

        Class<?> clazz = o.getClass();
        Field fields[] = clazz.getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                String fieldName = field.getName();

                ArrayList<String> valueList = new ArrayList<String>();

                Class<?> t = field.getType();

                /**
                 * 保证能访问到所有的成员变量
                 */
                field.setAccessible(true);

                Object fieldObject = field.get(o);
                if (fieldObject == null) {
                    continue;
                }

                if (t.isArray()) {
                    t = t.getComponentType();
                    if (t.isPrimitive()) {
                        convertLeatPrimitiveArray(fieldObject, t, valueList);
                    } else {
                        Object[] fieldObject2 = (Object[]) fieldObject;
                        convertLeatObjectArray(fieldObject2, t, valueList);
                    }
                    fieldName += "[]";
                } else {
                    convertLeafObject(fieldObject, t, valueList);
                }

                retMap.put(fieldName, valueList);
            }
        }

        return retMap;
    }
}
