package com.atguigu.guli.service.edu.client;

import com.atguigu.guli.common.base.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author zsf
 * @create 2019-12-06 18:35
 */

@Component
@FeignClient("guli-oss")
public interface OssClient {

    @DeleteMapping(value = "/admin/oss/file/remove")
    public R removeFile(
            @RequestBody String objectName);
}