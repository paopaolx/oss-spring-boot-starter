package com.kyrielx.oss;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kyrielx
 * @date 2023/4/7 9:48
 */
@Data
@ConfigurationProperties(prefix = "oss")
public class OssProperties {
    /**
     * 对象存储服务的url
     */
    private String endpoint;
    /**
     * 区域
     */
    private String region;
    /**
     * 配置url的显示格式
     * true nginx反向代理和S3默认支持pathStyle模式 {http://endpoint/bucketname}
     * false 支持virtual-hosted-style 阿里云需要配置为 virtual-hosted-style模式 {http://bucketname.endpoint}
     */
    private Boolean pathStyleAccess = true;
    private String accessKey;
    private String secretKey;
    /**
     * 最大线程数
     */
    private Integer maxConnections = 100;
}
