package com.zoeyun.mypays.sdk.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(MypaysPropeties.PREFIX)
public class MypaysPropeties {
    public static final String PREFIX = "zoeyun.mypays";
    String clientId;
    String clientSecret;
    String rsaPubKey;
    String rsaPriKey;
    String merchantCode;
    String channelCode;
}
