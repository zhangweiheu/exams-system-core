/**
 *
 */
package com.online.exams.system.core.config;

import com.online.exams.system.core.redis.RedisTemplateSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * redis通用配置
 *
 * @author tanxianwen 2015年9月25日
 */
@Configuration
public class RedisConfiguration {

    @Autowired
    private CoreProperties coreProperties;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        CoreProperties prop = coreProperties;

        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(prop.getRedisMaxIdle()); // <!--最小空闲连接数 -->
        jedisPoolConfig.setMaxTotal(prop.getRedisMaxTotal()); // <!--最大连接数 -->
        jedisPoolConfig.setMaxWaitMillis(prop.getRedisMaxWaitMillis()); // <!-- 获取连接时的最大等待毫秒数 -->
        jedisPoolConfig.setTestOnBorrow(prop.isRedisTestOnBorrow()); // <!-- 在获取连接的时候检查有效性, 默认false -->

        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(jedisPoolConfig);
        connectionFactory.setHostName(prop.getRedisHostName());
        connectionFactory.setPort(prop.getRedisHostPort());
        connectionFactory.setUsePool(true);
        connectionFactory.setTimeout(prop.getRedisTimeout());
        connectionFactory.setPassword(prop.getRedisPassword());
        connectionFactory.setDatabase(prop.getRedisCacheDatabase());
        return connectionFactory;
    }

    @Bean
    public StringRedisTemplate redisTemplate() {
        StringRedisTemplate tpl = new StringRedisTemplate(jedisConnectionFactory());
        tpl.setKeySerializer(stringRedisSerializer());
        tpl.setValueSerializer(genericJackson2JsonRedisSerializer());
        tpl.setHashKeySerializer(stringRedisSerializer());
        tpl.setHashValueSerializer(genericJackson2JsonRedisSerializer());
        return tpl;
    }

    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }

    @Bean
    public RedisTemplateSupport redisTemplateSupport() {
        RedisTemplateSupport support = new RedisTemplateSupport();
        support.setConnectionFactory(jedisConnectionFactory());

        support.setKeySerializer(stringRedisSerializer());
        support.setValueSerializer(genericJackson2JsonRedisSerializer());
        support.setHashKeySerializer(stringRedisSerializer());
        support.setHashValueSerializer(genericJackson2JsonRedisSerializer());
        return support;
    }

    @Bean
    public JedisPool jedisPool() {
        CoreProperties prop = coreProperties;
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPool jedisPool =
                new JedisPool(jedisPoolConfig, prop.getRedisHostName(), prop.getRedisHostPort(), prop.getRedisTimeout(), prop.getRedisPassword(), prop.getRedisCacheDatabase());
        return jedisPool;
    }
}
