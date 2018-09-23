package com.lanhu.work.bean;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lanhu.work.config.RedissionConfig;

//@Configuration
public class RedissonBean {
	
	
    @Autowired
	private RedissionConfig redissionConfig;
	
    /**
     * 哨兵模式自动装配
     * @return
     */
    @Bean
    @ConditionalOnProperty(name="redisson.master-name")
    RedissonClient redissonSentinel() {
        Config config = new Config();
        SentinelServersConfig serverConfig = config.useSentinelServers().addSentinelAddress(redissionConfig.getSentinelAddresses())
                .setMasterName(redissionConfig.getMasterName())
                .setTimeout(redissionConfig.getTimeout())
                .setMasterConnectionPoolSize(redissionConfig.getMasterConnectionPoolSize())
                .setSlaveConnectionPoolSize(redissionConfig.getSlaveConnectionPoolSize());
        
        if(StringUtils.isEmpty(redissionConfig.getPassword())) {
            serverConfig.setPassword(redissionConfig.getPassword());
        }
        return Redisson.create(config);
    }

    /**
     * 单机模式自动装配
     * @return
     */
    @Bean
    @ConditionalOnProperty(name="redisson.address")
    RedissonClient redissonSingle() {
        Config config = new Config();
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(redissionConfig.getAddress())
                .setTimeout(redissionConfig.getTimeout())
                .setConnectionPoolSize(redissionConfig.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redissionConfig.getConnectionMinimumIdleSize());
        
        if(StringUtils.isNoneBlank(redissionConfig.getPassword())) {
            serverConfig.setPassword(redissionConfig.getPassword());
        }

        return Redisson.create(config);
    }
    
    

}
