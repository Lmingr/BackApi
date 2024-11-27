package com.example.backapi.service.impl;

import com.example.backapi.mapper.UserMapper;
import com.example.backapi.pojo.User;
import com.example.backapi.pojo.UserForLogin;
import com.example.backapi.service.IUserService;
import com.example.backapi.service.ex.InsertException;
import com.example.backapi.service.ex.PasswordNotMatchException;
import com.example.backapi.service.ex.UserNotFoundException;
import com.example.backapi.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service   //@Service 将当前类的对象交给Spring管理，自动创建对象并管理
public class UserServiceImpl implements IUserService {


    @Autowired
    private  UserMapper  userMapper;

    /**
     * 处理注册的具体功能
     * @param user 用户的对象数据
     */
    @Override
    public void register(User user) {

        String username=user.getUsername();
        //判断用户否存在
        User result=  userMapper.findUserByName(username);
        //如果存在，抛出异常
        if(result!=null){
            //如果存在，抛出异常
            throw new UsernameDuplicatedException(username+"已经被占用");
        }

        //密码加密处理，md5算法
        //（串+password+串）----md5算法进行加密，连续加载三次
        //盐值+password+盐值--盐值就是一个随机的字符串
        String oldPassword=  user.getPassword();
        //获取盐值（随机生成一个盐值）
        String salt=UUID.randomUUID().toString().toUpperCase();

        //将密码和盐值作为一个整体进行加密处理,忽略原有密码强度
        String md5Password= getMD5PASSWORD(oldPassword,salt);


        //补全数据，新密码和盐值的记录
        user.setSalt(salt);
        user.setPassword(md5Password);

        //补全数据 is_delete=0
        user.setIsDelete(0);
        //补全数据 四个日志信息
        user.setCreatedUser(username);
        user.setModifiedUser(username);
        Date date=new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        //如果不存在，执行插入数据库操作来实现业务注册功能
        Integer rows=  userMapper.insert(user);
        //如果插入失败，报未知插入异常
        if (rows!=1){
            throw new InsertException("在用户注册过程中产生未知异常！");
        }

    }

    /**
     * 处理登录的具体功能
     * @return
     */
    @Override
    public User login(UserForLogin userForLogin) {
        //判断用户否存在，不存在抛异常
        User result=userMapper.findUserByName(userForLogin.getUsername());

        if (result==null){
            throw new UserNotFoundException("用户不存在！");
        }

        //检测用户密码是否匹配
        //先获取数据库加密之后的密码
        String oldPassword=result.getPassword();
        //先获取盐值
        String salt=result.getSalt();
        //将用户的密码按照相同的规则进行加密进行加密
        String newMD5Password= getMD5PASSWORD(userForLogin.getPassword(),salt);
        //密码进行比较
        if(!newMD5Password.equals(oldPassword)){
            throw new PasswordNotMatchException("密码不匹配！");
        }
        //判断用户是否注销
        if (result.getIsDelete() == 1){
            throw new UserNotFoundException("用户已注销");
        }

        //查询部分有用数据出来
        User user=new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvater(result.getAvater());

        return user;
    }


    /**
     * 使用md5加密算法对密码进行加密处理
     * 使用spring的工具类DigestUtils来实现md5加密算法
     * @param password
     * @param salt
     * @return
     */
    private String getMD5PASSWORD(String password,String salt){
        //md5加密算法，三次加密
        for (int i = 0; i <3 ; i++) {
            password= DigestUtils.md5DigestAsHex((salt+password+salt).getBytes());
        }
        //返回加密后的密码
        return password;
    }





}
