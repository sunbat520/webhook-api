/**
 * Copyright (c) 2016-2019 楚天云 All rights reserved.
 * <p>
 * http://www.chutianyun.gov.cn
 * <p>
 * 版权所有，侵权必究！
 */

package com.sunbat.webhookapi.common.utils;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 *
 * @author Domoke idomore89@gmail.com
 */
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private ValueOperations<String, String> valueOperations;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Value("${spring.profiles.active}")
    private String active;

    /**
     * 默认过期时长24小时，单位：秒
     */
    public final static long DEFAULT_EXPIRE = 60 * 60 * 24;
    /**
     * 不设置过期时长
     */
    public final static long NOT_EXPIRE = -1;
    private final static Gson gson = new Gson();

    public void set(String key, Object value, long expire) {
        valueOperations.set(key, toJson(value));
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
    }

    public void set(String key, Object value) {
        set(key, value, DEFAULT_EXPIRE);
    }

    public <T> T get(String key, Class<T> clazz, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value == null ? null : fromJson(value, clazz);
    }

    public <T> T get(String key, Class<T> clazz) {
        return get(key, clazz, NOT_EXPIRE);
    }

    public String get(String key, long expire) {
        String value = valueOperations.get(key);
        if (expire != NOT_EXPIRE) {
            redisTemplate.expire(key, expire, TimeUnit.SECONDS);
        }
        return value;
    }

    public String get(String key) {
        return get(key, NOT_EXPIRE);
    }

    public void delete(String key) {
        redisTemplate.delete(key);

    }

    /**
     * Object转成JSON数据
     */
    private String toJson(Object object) {
        if (object instanceof Integer || object instanceof Long || object instanceof Float || object instanceof Double
                || object instanceof Boolean || object instanceof String) {
            return String.valueOf(object);
        }
        return gson.toJson(object);
    }

    /**
     * JSON数据，转成Object
     */
    private <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    /**
     * 获取全部的keys
     */
    public Set<String> getKeys(String key) {
        return stringRedisTemplate.keys(key);
    }

    /**
     * 获取key1的剩余时间的时间戳
     */
    public Long getExpire(String key) {
        return stringRedisTemplate.getExpire(key);
    }

    public void addToSet(String key, String... values) {
        stringRedisTemplate.opsForSet().add(key, values);
    }

    public void removeFromSet(String key, String... values) {
        stringRedisTemplate.opsForSet().remove(key, values);
    }

    public long setSize(String key) {
        return stringRedisTemplate.opsForSet().size(key);
    }

    public boolean isMemberOfSet(String key, String value) {
        return stringRedisTemplate.opsForSet().isMember(key, value);
    }

    public Iterable<String> getMembersOfSet(String key) {
        return stringRedisTemplate.opsForSet().members(key);
    }
}
