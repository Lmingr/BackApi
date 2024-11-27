package com.example.backapi.service;


import com.example.backapi.pojo.User;
import com.example.backapi.pojo.UserForLogin;

/**
 *  用户模块业务层接口
 */
public interface IUserService {

    /**
     * 用户注册
     * @param user 用户的对象数据
     */
    void  register(User user);

    /**
     * 用户登录
     * @param userForLogin
     * @return
     */
    User  login(UserForLogin userForLogin);
}
