package com.example.backapi.mapper;


import com.example.backapi.pojo.ChatUser;
import com.example.backapi.pojo.MessageBean;

import java.util.List;


public interface UserMapper {
    /**
     * 插入用户的数据
     * @param chatUser
     * @return 受影响的行数
     */
    Integer chatInsert(ChatUser chatUser);

    /**
     * 通过用户名查询数据
     * @param username
     * @return  找到返回用户信息，没找到返回null
     */
    ChatUser findChatUserByName(String username);

    /**
     * 更新message和其他个人信息
     * @return 修改成功的行数
     */
    Integer updateByName(ChatUser chatUser);

}
