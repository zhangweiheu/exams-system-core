/**
 *
 */
package com.online.exams.system.core.config;

import com.google.common.collect.Lists;
import com.mongodb.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.WriteResultChecking;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * mongo db 的通用配置
 *
 * @author tanxianwen 2015年10月30日
 */
@Configuration
public class MongoConfiguration {

    @SuppressWarnings("deprecation")
    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        // MongoClientFactoryBean mongo = new MongoClientFactoryBean();
        List<ServerAddress> servers = new ArrayList<>();
//        servers.add(new ServerAddress("45.32.47.210"));
        servers.add(new ServerAddress("192.168.1.115"));

        MongoClientOptions.Builder bd = MongoClientOptions.builder();
        bd.connectTimeout(15000);
        bd.autoConnectRetry(true);
        bd.readPreference(ReadPreference.primaryPreferred());
        bd.connectionsPerHost(100);
        bd.threadsAllowedToBlockForConnectionMultiplier(50);
        bd.maxWaitTime(15000);
        bd.socketKeepAlive(true);
        bd.socketTimeout(15000);
        bd.writeConcern(WriteConcern.FSYNCED);

        List<MongoCredential> cr = getMongoCredential(null, "graduation", null);
        return new MongoClient(servers, cr, bd.build());
    }

    private List<MongoCredential> getMongoCredential(String username, String database, String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return null;
        }
        return Lists.newArrayList(MongoCredential.createCredential(username, database, password.toCharArray()));
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate tmp = new MongoTemplate(mongoDbFactory(), mappingMongoConverter());
        tmp.setWriteResultChecking(WriteResultChecking.EXCEPTION);
        return tmp;
    }

    @Bean
    public MongoMappingContext mongoMappingContext() throws ClassNotFoundException {
        MongoMappingContext mappingContext = new MongoMappingContext();
        return mappingContext;
    }

    @Bean
    public MappingMongoConverter mappingMongoConverter() throws Exception {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory());
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext());
        DefaultMongoTypeMapper mapper = new DefaultMongoTypeMapper(null); // 这里设置为空,可以把多余保存的_class[没用的字段]kill掉
        converter.setTypeMapper(mapper);
        return converter;
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(mongoClient(), "graduation");
    }
}
