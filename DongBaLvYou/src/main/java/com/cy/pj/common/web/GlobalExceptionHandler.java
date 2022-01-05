package com.cy.pj.common.web;


import com.cy.pj.common.vo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

/**
 * @ControllerAdvice注解描述的类为spring mvc中的一个全局异常处理类
 * 此类中可以定义多个全局异常处理方法，这些方法需要使用@ExceptionHandler注解进行修饰，
 * @ExceptionHandler中定义的异常类型为此方法可以处理的异常类型
 **/

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public JsonResult doHandleRuntimeException(IllegalArgumentException e) {
        System.out.println("IllegalArgumentException.doHandleRuntimeException");
        e.printStackTrace();
        return new JsonResult(e);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public JsonResult doHandleRuntimeException(NoSuchElementException e) {
        System.out.println("IllegalArgumentException.doHandleRuntimeException");
        e.printStackTrace();
        return new JsonResult(e);
    }

    @ExceptionHandler(RuntimeException.class)
    public JsonResult doHandleRuntimeException(RuntimeException e) {
        System.out.println("GlobalExceptionHandler.doHandleRuntimeException");
        e.printStackTrace();
        return new JsonResult(e);
    }
}
