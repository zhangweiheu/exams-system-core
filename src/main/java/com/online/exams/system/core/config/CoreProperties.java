/**
 *
 */
package com.online.exams.system.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 * 通用配置
 *
 * @author tanxianwen 2015年10月10日
 */
@Configuration
public class CoreProperties {

    //mysql配置
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String dbUsername;
    @Value("${spring.datasource.password}")
    private String dbPassword;
    @Value("${spring.datasource.driver-class-name}")
    private String dbDriver;
    @Value("${spring.datasource.connection-test-query}")
    private String dbTestQuery;

    // mongo db config
    @Value("${spring.data.mongodb.host}")
    private String mongoReplicaSet;
    @Value("${spring.data.mongodb.database}")
    private String mongoDbName;
    @Value("${spring.data.mongodb.username}")
    private String mongoUsername;
    @Value("${spring.data.mongodb.password}")
    private String mongoPassword;
    @Value("${mongo.connectionsPerHost:100}")
    private int mongoConnectionsPerHost;
    @Value("${mongo.threadsAllowedToBlockForConnectionMultiplier:5}")
    private int mongoThreadsAllowedToBlockForConnectionMultiplier;
    @Value("${mongo.connectTimeout:1500}")
    private int mongoConnectTimeout;
    @Value("${mongo.maxWaitTime:1500}")
    private int mongoMaxWaitTime;
    @Value("${mongo.socketKeepAlive:true}")
    private boolean mongoSocketKeepAlive;
    @Value("${mongo.socketTimeout:1500}")
    private int mongoSocketTimeout;

    //rabbitmq配置
    @Value("${spring.rabbitmq.addresses}")
    private String rabbitMQAddresses;
    @Value("${spring.rabbitmq.username}")
    private String rabbitMQUsername;
    @Value("${spring.rabbitmq.password}")
    private String rabbitMQPassword;
    @Value("${spring.rabbitmq.queue}")
    private String rabbitMQQueue;
    @Value("${spring.rabbitmq.exchange}")
    private String rabbitMQExchange;

    //redis配置
    @Value("${spring.redis.host}")
    private String redisHostName;
    @Value("${spring.redis.password}")
    private String redisPassword;
    @Value("${spring.redis.port}")
    private int redisHostPort;
    @Value("${spring.redis.max-idle:10}")
    private int redisMaxIdle;
    @Value("${spring.redis.max-active:100}")
    private int redisMaxTotal;
    @Value("${spring.redis.max-wait:10000}")
    private int redisMaxWaitMillis;
    @Value("${spring.redis.timeout:5000}")
    private int redisTimeout;
    @Value("${spring.redis.testOnBorrow}")
    private boolean redisTestOnBorrow;
    @Value("${spring.redis.database}")
    private int redisCacheDatabase;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getDbUsername() {
        return dbUsername;
    }

    public void setDbUsername(String dbUsername) {
        this.dbUsername = dbUsername;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbTestQuery() {
        return dbTestQuery;
    }

    public void setDbTestQuery(String dbTestQuery) {
        this.dbTestQuery = dbTestQuery;
    }

    public void setDbPassword(String dbPassword) {
        this.dbPassword = dbPassword;
    }

    public String getMongoReplicaSet() {
        return mongoReplicaSet;
    }

    public void setMongoReplicaSet(String mongoReplicaSet) {
        this.mongoReplicaSet = mongoReplicaSet;
    }

    public String getMongoDbName() {
        return mongoDbName;
    }

    public void setMongoDbName(String mongoDbName) {
        this.mongoDbName = mongoDbName;
    }

    public String getMongoUsername() {
        return mongoUsername;
    }

    public void setMongoUsername(String mongoUsername) {
        this.mongoUsername = mongoUsername;
    }

    public String getMongoPassword() {
        return mongoPassword;
    }

    public void setMongoPassword(String mongoPassword) {
        this.mongoPassword = mongoPassword;
    }

    public int getMongoConnectionsPerHost() {
        return mongoConnectionsPerHost;
    }

    public void setMongoConnectionsPerHost(int mongoConnectionsPerHost) {
        this.mongoConnectionsPerHost = mongoConnectionsPerHost;
    }

    public int getMongoThreadsAllowedToBlockForConnectionMultiplier() {
        return mongoThreadsAllowedToBlockForConnectionMultiplier;
    }

    public void setMongoThreadsAllowedToBlockForConnectionMultiplier(int mongoThreadsAllowedToBlockForConnectionMultiplier) {
        this.mongoThreadsAllowedToBlockForConnectionMultiplier = mongoThreadsAllowedToBlockForConnectionMultiplier;
    }

    public int getMongoConnectTimeout() {
        return mongoConnectTimeout;
    }

    public void setMongoConnectTimeout(int mongoConnectTimeout) {
        this.mongoConnectTimeout = mongoConnectTimeout;
    }

    public int getMongoMaxWaitTime() {
        return mongoMaxWaitTime;
    }

    public void setMongoMaxWaitTime(int mongoMaxWaitTime) {
        this.mongoMaxWaitTime = mongoMaxWaitTime;
    }

    public boolean isMongoSocketKeepAlive() {
        return mongoSocketKeepAlive;
    }

    public void setMongoSocketKeepAlive(boolean mongoSocketKeepAlive) {
        this.mongoSocketKeepAlive = mongoSocketKeepAlive;
    }

    public int getMongoSocketTimeout() {
        return mongoSocketTimeout;
    }

    public void setMongoSocketTimeout(int mongoSocketTimeout) {
        this.mongoSocketTimeout = mongoSocketTimeout;
    }

    public String getRabbitMQAddresses() {
        return rabbitMQAddresses;
    }

    public void setRabbitMQAddresses(String rabbitMQAddresses) {
        this.rabbitMQAddresses = rabbitMQAddresses;
    }

    public String getRabbitMQUsername() {
        return rabbitMQUsername;
    }

    public void setRabbitMQUsername(String rabbitMQUsername) {
        this.rabbitMQUsername = rabbitMQUsername;
    }

    public String getRabbitMQPassword() {
        return rabbitMQPassword;
    }

    public void setRabbitMQPassword(String rabbitMQPassword) {
        this.rabbitMQPassword = rabbitMQPassword;
    }

    public String getRabbitMQQueue() {
        return rabbitMQQueue;
    }

    public void setRabbitMQQueue(String rabbitMQQueue) {
        this.rabbitMQQueue = rabbitMQQueue;
    }

    public String getRabbitMQExchange() {
        return rabbitMQExchange;
    }

    public void setRabbitMQExchange(String rabbitMQExchange) {
        this.rabbitMQExchange = rabbitMQExchange;
    }

    public String getRedisHostName() {
        return redisHostName;
    }

    public void setRedisHostName(String redisHostName) {
        this.redisHostName = redisHostName;
    }

    public String getRedisPassword() {
        return redisPassword;
    }

    public void setRedisPassword(String redisPassword) {
        this.redisPassword = redisPassword;
    }

    public int getRedisHostPort() {
        return redisHostPort;
    }

    public void setRedisHostPort(int redisHostPort) {
        this.redisHostPort = redisHostPort;
    }

    public int getRedisMaxIdle() {
        return redisMaxIdle;
    }

    public void setRedisMaxIdle(int redisMaxIdle) {
        this.redisMaxIdle = redisMaxIdle;
    }

    public int getRedisMaxTotal() {
        return redisMaxTotal;
    }

    public void setRedisMaxTotal(int redisMaxTotal) {
        this.redisMaxTotal = redisMaxTotal;
    }

    public int getRedisMaxWaitMillis() {
        return redisMaxWaitMillis;
    }

    public void setRedisMaxWaitMillis(int redisMaxWaitMillis) {
        this.redisMaxWaitMillis = redisMaxWaitMillis;
    }

    public int getRedisTimeout() {
        return redisTimeout;
    }

    public void setRedisTimeout(int redisTimeout) {
        this.redisTimeout = redisTimeout;
    }

    public boolean isRedisTestOnBorrow() {
        return redisTestOnBorrow;
    }

    public void setRedisTestOnBorrow(boolean redisTestOnBorrow) {
        this.redisTestOnBorrow = redisTestOnBorrow;
    }

    public int getRedisCacheDatabase() {
        return redisCacheDatabase;
    }

    public void setRedisCacheDatabase(int redisCacheDatabase) {
        this.redisCacheDatabase = redisCacheDatabase;
    }
}
