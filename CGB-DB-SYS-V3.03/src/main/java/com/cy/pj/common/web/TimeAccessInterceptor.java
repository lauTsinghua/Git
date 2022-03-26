package com.cy.pj.common.web;

import com.cy.pj.common.exception.ServiceException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
/**
 * 限制时间段进行访问
 * **/
public class TimeAccessInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=============preHandle=====================");

        Calendar c = Calendar.getInstance();//获得当前时间的日历对象
        /**上午9:00到下午4:00可以访问**/
        c.set(Calendar.HOUR_OF_DAY, 9);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        long start = c.getTimeInMillis();
        c.set(Calendar.HOUR_OF_DAY, 17);
        long end = c.getTimeInMillis();
        long nowTime = System.currentTimeMillis();
        if (nowTime <start ||nowTime >end)
            throw new ServiceException("请在每天早上8:00~下午5:00之前访问") ;
        return true;//true代表可以放行,false代表不能放行
    }
}
