package com.example.backapi.mapper;


import com.example.backapi.pojo.ChatUser;
import com.example.backapi.pojo.User;
import com.example.backapi.pojo.MessageBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {

    @Autowired
    private  UserMapper userMapper;


    @Test
    public  void insert(){
        User user =new User();
        user.setUsername("luomingrong");
        user.setPassword("1231231");
        Integer row=  userMapper.insert(user);
        System.out.println("添加成功"+row);
    }


    @Test
    public  void findByUsername(){
      User user=  userMapper.findUserByName("Tom");
        System.out.println("查询："+user);
    }


    @Test
    public void testAddUser() {
        ChatUser chatUser=new ChatUser();
        chatUser.setUsername("luomingrong");
        chatUser.setPassword("1231231");

        List<MessageBean> message = new ArrayList<>();
        message.add(new MessageBean("你好","这是什么"));
        message.add(new MessageBean("我不好","这是什么我的"));
        chatUser.setMessage(message);

        Integer row= userMapper.chatInsert(chatUser);
        System.out.println("添加成功"+row);

    }

    @Test
    public  void testfindChatUse(){
        ChatUser user = userMapper.findChatUserByName("luomingrong");
        System.out.println(user);

    }



}
