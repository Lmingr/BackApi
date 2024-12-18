package com.example.backapi.controller;


import com.example.backapi.pojo.*;
import com.example.backapi.service.IUserService;
import com.example.backapi.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("users")
public class UserController extends BaseController{

    @Autowired
    //控制层依赖于业务逻辑的接口
    private IUserService iUserService;


    /**
     * 约定大于配置的开发理念
     * 1.接收数据的方式：请求处理方法的参数列表设置为pojo类型来接收前端的数据
     * SpringBoot会将前端的url地址中的参数名和pojo类的属性名进行比较，如果这两个名称相同，则会将值注入pojo类中的对应属性上
     * 如果名称不匹配，SpringBoot会自动忽略该属性
     * 如果前端发送的数据中没有对应的属性，那么该属性在pojo类中将为null
     * @param user
     * @return
     */
    @PostMapping ("register")
    public JsonResult<Void> register(@RequestBody ChatUser user){
        iUserService.register(user);
        return  new JsonResult<>(SUCCESS);
    }

    /**
     *2、接收数据方式：请求处理方法的参数列表设置为普通类型来接收前端的数据（非pojo类型）
     * SpringBoot会将前端的url地址中的参数名和方法参数名进行比较，如果这两个名称相同，则会将值依赖注入方法参数中
     * @param userForLogin
     * @return
     */

    @PostMapping("login")
    public JsonResult<ChatUser> login(@RequestBody UserForLogin userForLogin){
        ChatUser user= iUserService.login(userForLogin);
        return new JsonResult<>(SUCCESS,user);
    }

    /**
     * 更新数据表格
     * @param user
     * @return
     */
    @PostMapping("update")
    public  JsonResult<Void> update(@RequestBody ChatUser user){
        iUserService.update(user);
        return new JsonResult<>(SUCCESS);
    }


    /**
     * 更新数据信息
     * @param userMessage
     * @return
     */
    @PostMapping("message")
    public  JsonResult<Void> updateMessage(@RequestBody UserMessage userMessage){
        iUserService.updateMessage(userMessage);
        return new JsonResult<>(SUCCESS);
    }

    /**
     * 新增数据信息
     * @param chatMessage
     * @return
     */
    @PostMapping("insert")
    public JsonResult<Void> insert(@RequestBody ChatMessage chatMessage){
        iUserService.insertMessage(chatMessage);
        return  new JsonResult<>(SUCCESS);
    }

    /**
     * 查询用户的信息
     * @param username
     * @return
     */
    @GetMapping("found")
    public JsonResult<ChatUser> found(String username){
        ChatUser user= iUserService.found(username);
        return new JsonResult<>(SUCCESS,user);
    }

    /**
     * 查询用户的聊天信息列
     * @param username
     * @return
     */
    @GetMapping("foundlist")
    public  JsonResult<List<ChatMessage>>  foundMessageList(String username){
        List<ChatMessage> chatMessageList= iUserService.foundMessageList(username);
        return new JsonResult<>(SUCCESS,chatMessageList);
    }


    @GetMapping("foundmessage")
    public JsonResult<ChatMessage>  foundMessage(Integer mid){
        ChatMessage chatMessage= iUserService.foundMessage(mid);
        return new JsonResult<>(SUCCESS,chatMessage);
    }

}

