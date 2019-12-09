package com.atguigu.guli.service.sms.service;

import java.util.Map;

/**
 * @author zsf
 * @create 2019-12-09 18:51
 */

public interface SmsService {
    void send(String PhoneNumbers, Map<String,Object> param);
}