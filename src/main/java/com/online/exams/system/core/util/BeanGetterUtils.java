package com.online.exams.system.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Bean工具类
 */
@Lazy(false)
@Component
public class BeanGetterUtils implements ApplicationContextAware {
    private static Logger logger = LoggerFactory.getLogger(BeanGetterUtils.class);
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BeanGetterUtils.applicationContext = applicationContext;
    }

    public static Object getBean(String beanName) {
        try {
            return applicationContext.getBean(beanName);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        Object bean = getBean(beanName);
        return bean == null ? null : clazz.cast(bean);
    }

    public static <T> T getBean(String beanName, Class<T> clazz, Class<? extends T> defaultClazz) {
        Object bean = getBean(beanName);
        try {
            return bean == null ? defaultClazz.newInstance() : clazz.cast(bean);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
