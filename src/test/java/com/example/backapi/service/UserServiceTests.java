package com.example.backapi.service;


import com.example.backapi.pojo.ChatUser;
import com.example.backapi.pojo.MessageBean;
import com.example.backapi.pojo.UserForLogin;
import com.example.backapi.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
            List<MessageBean> message = new ArrayList<>();
            message.add(new MessageBean("你好","你好啊"));
            message.add(new MessageBean("你好","你好我是人工智能AI"));
            user.setMessage(message);
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
    public  void update(){
        ChatUser user =iUserService.found("luomingr");

        List<MessageBean> message = new ArrayList<>();
        message.add(new MessageBean("你好","你是天才"));
        user.setMessage(message);

        iUserService.update(user);
        System.out.println("修改成功");
    }




}
