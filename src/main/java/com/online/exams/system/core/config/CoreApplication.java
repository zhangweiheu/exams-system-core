package com.online.exams.system.core.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by zhangwei on 16/1/25.
 */
@Configuration
@EnableAutoConfiguration
@Import({MyBatisConfiguration.class,MongoConfiguration.class,RabbitConfiguration.class})
@ComponentScan(basePackageClasses = {com.online.exams.system.core.Pkg.class})
public class CoreApplication {
}
