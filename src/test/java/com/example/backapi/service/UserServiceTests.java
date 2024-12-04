package com.example.backapi.service;


import com.example.backapi.pojo.*;
import com.example.backapi.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private IUserService iUserService;

    /**
     * 单元测试方法，可以独立运行测试方法
     * 1、必须被@Test注解修饰
     * 2、返回值类型必须是void
     * 3、方法的参数列表不指定任何类型
     * 4、方法返回的修饰符必须是public
     */

    @Test
    public  void register(){
        try {
            ChatUser user =new ChatUser();
            user.setUsername("luomingr");
            user.setPassword("1231231");
            iUserService.register(user);
            System.out.println("注册成功");
        }catch (ServiceException e){
            //获取类的对象
            System.out.println(e.getClass().getSimpleName());
            //获取异常的具体描述信息
            System.out.println(e.getMessage());
        }

    }

    @Test
    public  void login(){
        ChatUser user= iUserService.login(new UserForLogin("luomingr","1231231"));
        System.out.println("登录成功"+user);
    }


    @Test
    public  void testMessageInsert(){
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setUsername("luomingr");
        chatMessage.setMessageTopic("你好吗你叫什么");
        chatMessage.setMessageContent("我叫AI");
        List<MessageBean> message = new ArrayList<>();
        message.add(new MessageBean("我","你是哪位啊兄弟"));
        message.add(new MessageBean("AI","你好我是人工智能AI"));
        chatMessage.setMessageList(message);
        iUserService.insertMessage(chatMessage);
        System.out.println("插入成功！！！");
    }


    @Test
    public void foundList(){
     List<ChatMessage> chatMessageList=   iUserService.foundMessageList("luomingr");

     for (ChatMessage chatMessage:chatMessageList){

         System.out.println(chatMessage);
     }
    }

     @Test
    public  void foundMessage(){
        ChatMessage chatMessage= iUserService.foundMessage(2);

         System.out.println(chatMessage);
     }

     @Test
     public  void updateMessage(){
         UserMessage userMessage=new UserMessage();
         userMessage.setMid(5);
         List<MessageBean> message = new ArrayList<>();
         message.add(new MessageBean("user","你是哪位啊兄弟"));
         message.add(new MessageBean("AI","你好我是人工智能AI"));
         message.add(new MessageBean("user","你好我是人工智能AI"));
         message.add(new MessageBean("AI","你好我是人工智能AI"));
         userMessage.setMessageList(message);
         iUserService.updateMessage(userMessage);
     }
}
