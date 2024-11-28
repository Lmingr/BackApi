package com.example.backapi.mapper;


import com.example.backapi.pojo.ChatUser;
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

    @Test
    public  void testppdate(){
        ChatUser chatUser=userMapper.findChatUserByName("luomingr");
        chatUser.setPhone("19802022111");
        List<MessageBean> message = new ArrayList<>();
        message.add(new MessageBean("你好","你是哪位啊兄弟"));
        message.add(new MessageBean("你好","你好我是人工智能AI"));
        message.add(new MessageBean("你好","你好我是人工智能AI"));
        message.add(new MessageBean("你好","你好我是人工智能AI"));
        message.add(new MessageBean("你好","你好我是人工智能AI"));
        chatUser.setMessage(message);
        Integer integer= userMapper.updateByName(chatUser);
        System.out.println(integer+"更新成功！！！");
    }


}
