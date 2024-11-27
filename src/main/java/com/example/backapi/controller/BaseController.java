package com.example.backapi.controller;


import com.example.backapi.service.ex.*;
import com.example.backapi.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** 控制层类的基类 */
public class BaseController {

    //操作成功的状态码
    protected static final int SUCCESS = 200;

    //操作失败的状态
    protected static final int FAIL = 400;
    //未登录的状态
    protected static final int NOT_LOGIN = 401;

    /**
     * 请求方法的处理eckException方法的异常处理器
     * 处理ServiceException异常
     * 这个注解表示这个方法可以处理ServiceException异常
     * 当出现这个异常时，会被这个方法捕获，并执行下面的方法
     * 这个方法会返回一个JsonResult对象，这个对象包含了错误信息和状态码，然后被转换成json格式返回给前端
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>(e);
        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);//4000表示用户名重复错误
            result.setMessage("用户名已经被占用了");
        } else if (e instanceof UserNotFoundException){
            result.setState(4001);//4001表示用户名不存在错误
            result.setMessage("用户不存在");
        } else if (e instanceof PasswordNotMatchException){
            result.setState(4002);//4002表示密码错误错误
            result.setMessage("密码错误");
        } else if (e instanceof InsertException){
            result.setState(5000);
            result.setMessage("注册用户出现未知异常");
        }
        return result;//返回一个json格式的数据，包含状态码和错误信息<FAIL,e.getMessage()
    }



}
