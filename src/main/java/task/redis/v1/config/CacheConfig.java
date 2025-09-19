package task.redis.v1.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory factory) {
        // 1. Создаём конфигурацию для Redis-кэша
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(60)); // TTL 60 секунд

        // 2. На основе конфигурации строим CacheManager
        return RedisCacheManager.builder(factory)
                .cacheDefaults(config) // применяем конфиг по умолчанию
                .build();
    }

}