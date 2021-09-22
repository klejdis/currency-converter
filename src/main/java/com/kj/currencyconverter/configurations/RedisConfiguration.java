package com.kj.currencyconverter.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

       JedisConnectionFactory jedisConnectionFactory =  new JedisConnectionFactory();
       jedisConnectionFactory.setHostName("localhost");
       jedisConnectionFactory.setPort(6379);
       jedisConnectionFactory.afterPropertiesSet();

        template.setConnectionFactory(jedisConnectionFactory);
        template.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        return template;
    }
}
