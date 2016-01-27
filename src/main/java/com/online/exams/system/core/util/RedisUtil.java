package com.online.exams.system.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by vincent on 15/12/18.
 */
public final class RedisUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger(RedisUtil.class);

    private static JedisPool jedisPool = BeanGetterUtils.getBean("jedisPool", JedisPool.class);

    private static int DEFAULT_TIMEOUT_SECONDS = 30 * 24 * 60 * 60;

    public static void set(String key, String val, int timeoutSecond) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.set(key, val);
            jedis.expire(key, timeoutSecond);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (jedis != null)
                jedisPool.returnResource(jedis);
        }
    }

    public static long incr(String key, int timeoutSecond) {
        Long incrVal = 0l;
        Jedis jedis = jedisPool.getResource();
        try {
            incrVal = jedis.incr(key);
            jedis.expire(key, timeoutSecond);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (jedis != null)
                jedisPool.returnResource(jedis);
        }
        return incrVal;
    }

    public static void set(String key, String val) {
        set(key, val, DEFAULT_TIMEOUT_SECONDS);
    }

    public static void delete(String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(key);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (jedis != null)
                jedisPool.returnResource(jedis);
        }
    }

    public static String get(String key) {
        String val = null;
        Jedis jedis = jedisPool.getResource();
        try {
            val = jedis.get(key);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (jedis != null)
                jedisPool.returnResource(jedis);
        }
        return val;
    }

    public static boolean acquireLock(String lock, long DIS_LOCK_TIMEOUT) {
        boolean success = false;
        Jedis jedis = jedisPool.getResource();
        try {
            long value = System.currentTimeMillis() + DIS_LOCK_TIMEOUT + 1;
            long acquired = jedis.setnx(lock, String.valueOf(value));
            if (acquired == 1)
                success = true;
            else {
                long oldValue = Long.valueOf(jedis.get(lock));
                if (oldValue < System.currentTimeMillis()) {
                    String getValue = jedis.getSet(lock, String.valueOf(value));
                    success = Long.valueOf(getValue) == oldValue;
                } else {
                    success = false;
                }
            }
        } finally {
            if (jedis != null)
                jedisPool.returnResource(jedis);
        }
        LOGGER.info("acquireLock lock {} {}", lock, success);
        return success;
    }

    public static void releaseLock(String lock) {
        Jedis jedis = jedisPool.getResource();
        try {
            long current = System.currentTimeMillis();
            if (current < Long.valueOf(jedis.get(lock)))
                jedis.del(lock);
        } finally {
            if (jedis != null)
                jedisPool.returnResource(jedis);
        }
    }

}
