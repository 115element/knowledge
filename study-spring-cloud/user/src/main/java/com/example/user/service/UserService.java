package com.example.user.service;

import com.example.user.dataobject.UserInfo;

public interface UserService {

    /**
     * 通过openid查询用户信息
     * @param openid
     * @return
     */
    public UserInfo findByOpenid(String openid);
}
