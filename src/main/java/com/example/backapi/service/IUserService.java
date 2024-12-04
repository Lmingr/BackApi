package com.example.backapi.service;


import com.example.backapi.pojo.*;

import java.util.List;

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



    /**
     * 查询mid的单个信息条目
     * @param mid
     * @return
     */
    ChatMessage foundMessage(Integer mid);


    /**
     * 查询username的全部信息条目
     * @param username
     * @return
     */
   List<ChatMessage> foundMessageList(String username);


    /**
     * 插入信息条目
     */
    void  insertMessage(ChatMessage chatMessage);

    /**
     * 更新信息
     * @param userMessage
     */
    void updateMessage(UserMessage userMessage);
}
