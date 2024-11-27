package com.example.backapi.mapper;


import com.example.backapi.pojo.ChatUser;
import com.example.backapi.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper {

    /**
     * 插入用户的数据
     * @param user
     * @return 受影响的行数
     */
    Integer insert(User user);


    /**
     *  查找用户是否存在
     * @param username
     * @return  找到返回用户信息，没找到返回null
     */
    User  findUserByName(String username);


    /**
     * 插入用户的数据
     * @param chatUser
     * @return
     */
    Integer chatInsert(ChatUser chatUser);


    /**
     * 通过用户名查询数据
     * @param username
     * @return
     */
    ChatUser findChatUserByName(String username);



}
