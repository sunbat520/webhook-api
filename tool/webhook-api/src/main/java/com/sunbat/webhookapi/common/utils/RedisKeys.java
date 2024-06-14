package com.sunbat.webhookapi.common.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: SunYb
 * @date: 2024/6/13 16:13
 * @version: 1.0
 */
@Component
public class RedisKeys {

    private static String redisKeyPrefix;

    RedisKeys(@Value("${sunbat.redis.key-prefix}") String redisKeyPrefix) {
        RedisKeys.redisKeyPrefix = redisKeyPrefix;
    }


    public static String LETTER_MESSAGE = "letter_message";

    public static String getLetterMessage() {
        return redisKeyPrefix + ":" + LETTER_MESSAGE;
    }
}
