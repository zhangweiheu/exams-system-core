package com.online.exams.system.core.redis;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangwei on 16/1/25.
 */
public class RedisTemplateSupport extends RedisTemplate<String, Object> {

    /**
     * 计数器，可以用于实现限速器效果
     *
     * @param expiresAtFirst 第一次计数时设定成超时时间
     */
    public long incr(final String key, final long expiresAtFirst, final TimeUnit unit) {
        return execute(new SessionCallback<Long>() {
            @SuppressWarnings({"rawtypes"})
            public Long execute(RedisOperations ops) throws DataAccessException {
                if (!ops.hasKey(key)) {
                    ops.multi();
                    ops.opsForValue().increment(key, 1);
                    ops.expire(key, expiresAtFirst, unit);
                    return (Long) ops.exec().get(0);
                } else {
                    return ops.opsForValue().increment(key, 1);
                }
            }
        });
    }

    /**
     * 计数器，可以用于实现限速器效果，每次都重置过期时间
     *
     * @param expires 过期时间
     */
    public long incrAndSetExpires(final String key, final long expires, final TimeUnit unit) {
        return execute(new SessionCallback<Long>() {
            @SuppressWarnings({"rawtypes"})
            public Long execute(RedisOperations ops) throws DataAccessException {
                ops.multi();
                ops.opsForValue().increment(key, 1);
                ops.expire(key, expires, unit);
                return (Long) ops.exec().get(0);
            }
        });
    }

    public boolean exists(final String key) {
        return hasKey(key);
    }



    public void set(final String key, final java.lang.Object value, final long expires, TimeUnit unit) {
        if (expires <= 0) {
            opsForValue().set(key, value);
        } else {
            opsForValue().set(key, value, expires, unit);
        }
    }

    /**
     * 以某个key为锁, 实现分布锁
     *
     * @param expires 最多锁住时间
     * @return true：成功锁定， false：已被其他人锁定
     */
    public boolean tryLock(final String keyLock, final long expires, TimeUnit unit) {
        boolean success = opsForValue().setIfAbsent(keyLock, 1);
        if (success) {// 设置成功，证明给定的key不存在
            expire(keyLock, expires, unit);
            return true;
        } else {
            return false;
        }

        // if (hasKey(keyLock)) {
        // return false;
        // } else {
        // opsForValue().set(keyLock, 1, expires, unit);
        // return true;
        // }

    }

    /**
     * 等待锁直到锁被释放
     */
    public boolean waitForLockFree(final String keyLock) {
        boolean retry;
        boolean foundLock = false;
        do {
            retry = false;
            if (hasKey(keyLock)) {
                foundLock = true;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                retry = true;
            }
        } while (retry);

        return foundLock;
    }

    /**
     * 解分布式锁
     */
    public void unlock(final String keyLock) {
        delete(keyLock);
    }


    public void set(final String key, final java.lang.Object value) {
        opsForValue().set(key, value);
    }

    public <V> V get(final String key) {
        return (V) opsForValue().get(key);
    }

    public <K1, V1> void lpush(final K1 key, final V1 obj, final long expires, final TimeUnit timeUnit, final long limit) {
        execute(new SessionCallback<java.lang.Object>() {
            @Override
            public <K, V> java.lang.Object execute(RedisOperations<K, V> operations) throws DataAccessException {
                operations.multi();
                operations.opsForList().leftPush((K) key, (V) obj);
                if (limit != 0) {
                    operations.opsForList().trim((K) key, 0, limit - 1);
                }
                operations.expire((K) key, expires, timeUnit);

                List<java.lang.Object> exec = operations.exec();
                return null;
            }
        });
    }

    public <V> List<V> range(String key, long size) {
        return (List<V>) opsForList().range(key, 0, size - 1);
    }

    public <V1> void replaceList(final String key, final List<V1> list) {
        if (StringUtils.isNotBlank(key) && CollectionUtils.isNotEmpty(list)) {
            execute(new SessionCallback<java.lang.Object>() {
                @Override
                public <K, V> java.lang.Object execute(RedisOperations<K, V> operations) throws DataAccessException {
                    operations.multi();
                    operations.delete((K) key);
                    operations.opsForList().rightPushAll((K) key, (List<V>) list);

                    operations.exec();
                    return null;
                }
            });
        }
    }
}
