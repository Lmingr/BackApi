package com.example.backapi.mapper;


import com.example.backapi.pojo.ChatMessage;
import com.example.backapi.pojo.ChatUser;
import com.example.backapi.pojo.MessageBean;
import com.example.backapi.pojo.UserMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTests {

    @Autowired
    private  UserMapper userMapper;

    @Test
    public  void testfindChatUse(){
        ChatUser user = userMapper.findChatUserByName("luomingr");
        System.out.println(user);

    }



    @Test
    public  void testChatMessageInsert(){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername("luomingr");
        chatMessage.setMessageTopic("你好吗你叫什么");
        chatMessage.setMessageContent("我叫AI");
        List<MessageBean> message = new ArrayList<>();
        message.add(new MessageBean("我","你是哪位啊兄弟"));
        message.add(new MessageBean("AI","你好我是人工智能AI"));
        Date date=new Date();
        chatMessage.setMessageDate(date);
        chatMessage.setMessageList(message);
        Integer row=  userMapper.chatMessageInsert(chatMessage);
        System.out.println("插入成功！！！"+row);
    }

    @Test
    public void testFound(){
        List<ChatMessage> chatMessage=userMapper.findChatMessageListByUsername("luomingr");

        for (ChatMessage chatMessage1 : chatMessage) {
            System.out.println(chatMessage1.getMid());
        }
    }

}
