@Configuration

package com.example.apidmeo.redis;

import io.lettuce.core.dynamic.annotation.Value;
import org.springframework.context.annotation.Configuration;

public class RedisProperties {
    private int redisPort;
    private String redisHost;

    public RedisProperties(
            @Value("${spring.data.redis.port}") int redisPort,
            @Value("${spring.data.redis.host}") String redisHost) {
        this.redisPort = redisPort;
        this.redisHost = redisHost;
    }

    // getters
}
