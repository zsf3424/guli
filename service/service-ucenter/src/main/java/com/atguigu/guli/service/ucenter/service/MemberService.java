package com.atguigu.guli.service.ucenter.service;

import com.atguigu.guli.service.ucenter.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author zsf
 * @since 2019-12-05
 */
public interface MemberService extends IService<Member> {

    Integer countRegisterByDay(String day);

}
