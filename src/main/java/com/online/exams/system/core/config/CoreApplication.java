package com.online.exams.system.core.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by zhangwei on 16/1/25.
 */
@SpringBootApplication
@ComponentScan(basePackageClasses = com.online.exams.system.core.Pkg.class)
public class CoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }
}
