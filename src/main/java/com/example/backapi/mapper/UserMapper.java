package com.example.backapi.mapper;


import com.example.backapi.pojo.ChatMessage;
import com.example.backapi.pojo.ChatUser;
import com.example.backapi.pojo.MessageBean;
import com.example.backapi.pojo.UserMessage;

import java.util.List;


public interface UserMapper {
    /**
     * 插入用户的数据
     * @param chatUser
     * @return 受影响的行数
     */
    Integer chatInsert(ChatUser chatUser);



    /**
     * 插入信息的数据
     * @param chatMessage
     * @return
     */
    Integer chatMessageInsert(ChatMessage chatMessage);

    /**
     * 通过用户名查询数据
     * @param username
     * @return  找到返回用户信息，没找到返回null
     */
    ChatUser findChatUserByName(String username);


    /**
     * 通过用户名id查询信息表格
     * @param mid
     * @return
     */
    ChatMessage findChatMessageByMid(Integer mid);


    /**
     * 查询用户名为username的全部用户
     * @param username
     * @return
     */
    List<ChatMessage>   findChatMessageListByUsername(String username);


    /**
     * 更新其他个人信息
     * @return 修改成功的行数
     */
    Integer updateByName(ChatUser chatUser);


    /**
     * 更新Message 信息
     */
    Integer updateChatMessage(UserMessage userMessage);
}
