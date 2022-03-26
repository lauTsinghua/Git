package com.cy.pj.common.web;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author qilei
 * @ControllerAdvice 注解描述的类为spring mvc中的一个全局异常处理类
 * ，此类中可以定义多个全局异常处理方法，这些方法需要使用@ExceptionHandler注解
 * 进行修饰，@ExceptionHandler中定义的异常类型为此方法可以处理的异常类型(此方法
 * 还可以处理这个异常子类类型的异常)
 */
//@ControllerAdvice
//@ResponseBody
//@RestControllerAdvice=@ControllerAdvice+@ResponseBody
@RestControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(IllegalArgumentException.class)
//	@ResponseBody
//	public JsonResult doHandleRuntimeException(IllegalArgumentException e) {
//		System.out.println("GlobalExceptionHandler.doHandleRuntimeException");
//		e.printStackTrace();
//		return new JsonResult(e);//封装异常信息
//	}

    @ExceptionHandler(ShiroException.class)
    public JsonResult doHandleShiroException(ShiroException e) {
        JsonResult r = new JsonResult();
        r.setState(0);
        if (e instanceof UnknownAccountException)
            r.setMessage("账户不存在");
        else if (e instanceof LockedAccountException)
            r.setMessage("账户已被禁用");
        else if (e instanceof IncorrectCredentialsException)
            r.setMessage("密码不正确");
        else if (e instanceof AuthorizationException)
            r.setMessage("没有操作权限");
        else
            r.setMessage("系统维护中");
        e.printStackTrace();
        return r;
    }

    @ExceptionHandler(RuntimeException.class)

    public JsonResult doHandleRuntimeException(RuntimeException e) {
        System.out.println("GlobalExceptionHandler.doHandleRuntimeException");
        e.printStackTrace();
        return new JsonResult(e);//封装异常信息
    }

}
