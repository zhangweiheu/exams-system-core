package com.online.exams.system.core.config;

import com.online.exams.system.core.mybatis.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by 36kr on 16/1/28.
 */
@Configuration
@Import(CoreDataSourceConfiguration.class)
@MapperScan(basePackageClasses = {com.online.exams.system.core.mapper.Pkg.class}, sqlSessionFactoryRef = MyBatisConfiguration.SQL_SESSION_FACTORY_NAME)
public class MyBatisConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisConfiguration.class);
    public static final String SQL_SESSION_FACTORY_NAME = "exams_online_SqlSessionFactory";

    private String enumBasePackages = "com.online.exams.system.core.mybatis.enums";

    @Bean(name = MyBatisConfiguration.SQL_SESSION_FACTORY_NAME)
    public MybatisSqlSessionFactoryBean exams_online_MybatisSqlSessionFactoryBean(CoreDataSourceConfiguration config) {
        LOGGER.warn("check-MybatisSqlSessionFactoryBean-begin");
        MybatisSqlSessionFactoryBean sessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(config.core_dataSource());
        sessionFactoryBean.setEnumBasePackages(enumBasePackages);
        return sessionFactoryBean;
    }
}
