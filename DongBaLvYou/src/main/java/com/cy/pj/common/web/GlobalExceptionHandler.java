package com.cy.pj.common.web;

import com.cy.pj.common.vo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @ControllerAdvice 注解描述的类为spring mvc中的一个全局异常处理类
 * ，此类中可以定义多个全局异常处理方法，这些方法需要使用@ExceptionHandler注解
 * 进行修饰，@ExceptionHandler中定义的异常类型为此方法可以处理的异常类型(此方法
 * 还可以处理这个异常子类类型的异常)
 * @author qilei
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	 
//	@ExceptionHandler(IllegalArgumentException.class)
//	@ResponseBody
//	public JsonResult doHandleRuntimeException(IllegalArgumentException e) {
//		System.out.println("GlobalExceptionHandler.doHandleRuntimeException");
//		e.printStackTrace();
//		return new JsonResult(e);//封装异常信息
//	}
	 @ExceptionHandler(RuntimeException.class)
	 @ResponseBody
	 public JsonResult doHandleRuntimeException(RuntimeException e) {
		 System.out.println("GlobalExceptionHandler.doHandleRuntimeException");
		 e.printStackTrace();
		 return new JsonResult(e);//封装异常信息
	 }
	 //......
	 //......
}
