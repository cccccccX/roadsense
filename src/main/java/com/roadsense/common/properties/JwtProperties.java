package com.roadsense.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * author  Edith
 * created  2023/12/27 22:13
 */
@Component
@ConfigurationProperties(prefix = "mikasa.roadsense.jwt")
@Data
public class JwtProperties {
    /**
     *       secret-key: roadSense
     *       ttl: 7200000
     *       token-name: token
     */
    private String secretkey;
    private long ttl;
    private String tokenName;

}
