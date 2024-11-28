package com.example.backapi.service;


import com.example.backapi.pojo.ChatUser;
import com.example.backapi.pojo.UserForLogin;

/**
 *  用户模块业务层接口
 */
public interface IUserService {

    void  register(ChatUser user);

    /**
     * 用户登录
     * @param userForLogin
     * @return
     */
    ChatUser  login(UserForLogin userForLogin);


    /**
     * 修改用户信息
     * @param user
     */
    void  update(ChatUser user);


    /**
     * 查询用户
     * @param username
     * @return
     */
    ChatUser found(String username);


}
