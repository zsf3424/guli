package com.atguigu.guli.service.vod.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zsf
 * @create 2019-12-02 21:04
 */
@Data
@Component
//注意prefix要写到最后一个 "." 符号之前
@ConfigurationProperties(prefix="aliyun.vod.file")
public class VodProperties {
    private String keyid;
    private String keysecret;
}
