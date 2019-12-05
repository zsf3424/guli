package com.atguigu.guli.service.statistics.client;

import com.atguigu.guli.common.base.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zsf
 * @create 2019-12-05 15:29
 */

@Component
@FeignClient("guli-ucenter")
public interface UcenterClient {

    /**
     * 注意：一定要写成 @PathVariable("day")，圆括号中的"day"不能少
     * @param day
     * @return
     */
    @GetMapping(value = "/admin/ucenter/member/count-register/{day}")
    public R registerCount(@PathVariable("day") String day);
}
