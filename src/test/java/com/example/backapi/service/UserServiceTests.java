package com.example.backapi.service;


import com.example.backapi.mapper.UserMapper;
import com.example.backapi.pojo.User;
import com.example.backapi.pojo.UserForLogin;
import com.example.backapi.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
            User user =new User();
            user.setUsername("luomingr2");
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
       User user= iUserService.login(new UserForLogin("luomingr2","1231231"));
        System.out.println("登录成功"+user);
    }





}
