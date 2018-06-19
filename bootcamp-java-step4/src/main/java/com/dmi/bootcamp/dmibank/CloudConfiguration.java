package com.dmi.bootcamp.dmibank;

import javax.sql.DataSource;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import com.dmi.bootcamp.dmibank.service.HitCountService;
import com.dmi.bootcamp.dmibank.service.HitCountServiceRedis;

@Configuration
@Profile("cloud")
public class CloudConfiguration extends AbstractCloudConfig {
    
    @Bean
    public DataSource datasource() {
        return connectionFactory().dataSource();
    }

    @Bean
    public RedisConnectionFactory redisFactory() {
        return connectionFactory().redisConnectionFactory();
    }
    
    @Bean
    public RedisTemplate<String, Integer> redisTemplate() {
        RedisTemplate<String, Integer> template = new RedisTemplate<>();
        template.setConnectionFactory(redisFactory());
        template.setValueSerializer(new GenericToStringSerializer<>(Integer.class));
        return template;
    }
    
    @Bean
    public HitCountService hitCountService() {
        return new HitCountServiceRedis();
    }
}
