package com.zoeyun.mypays.sdk.configuration;

import com.zoeyun.mypays.sdk.common.redis.RedisOps;
import com.zoeyun.mypays.sdk.common.redis.RedisTemplateRedisOps;
import com.zoeyun.mypays.sdk.config.impl.MypaysDefaultConfigImpl;
import com.zoeyun.mypays.sdk.config.impl.MypaysRedisConfigImpl;
import com.zoeyun.mypays.sdk.service.MypaysService;
import com.zoeyun.mypays.sdk.service.impl.MypaysServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(MypaysPropeties.class)
public class MypaysConfiguration {

    @Autowired
    MypaysPropeties propeties;

    @Bean
    public MypaysService mypaysService() {
        MypaysDefaultConfigImpl defaultConfig = new MypaysDefaultConfigImpl();
        defaultConfig.setClientSecret(propeties.getClientSecret());
        defaultConfig.setClientId(propeties.getClientId());
        defaultConfig.setRsaPriKey(propeties.getRsaPriKey());
        defaultConfig.setRsaPubKey(propeties.getRsaPubKey());
        MypaysService mypaysService = new MypaysServiceImpl();
        mypaysService.setConfigStorage(defaultConfig);
        return mypaysService;
    }
}
