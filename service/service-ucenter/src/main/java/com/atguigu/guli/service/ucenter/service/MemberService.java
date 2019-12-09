package com.atguigu.guli.service.ucenter.service;

import com.atguigu.guli.service.ucenter.entity.Member;
import com.atguigu.guli.service.ucenter.entity.vo.LoginInfoVo;
import com.atguigu.guli.service.ucenter.entity.vo.LoginVo;
import com.atguigu.guli.service.ucenter.entity.vo.RegisterVo;
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

    /**
     * 用户注册
     * @param registerVo
     */
    void register(RegisterVo registerVo);

    /**
     * 用户登录
     * @param loginVo
     * @return token
     */
    String login(LoginVo loginVo);

    /**
     * 根据会员id获取会员登录信息
     * @param memberId
     * @return 用户登录信息
     */
    LoginInfoVo getLoginInfo(String memberId);

}
