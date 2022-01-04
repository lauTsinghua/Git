package com.cy.pj.sys.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class PageController {


    @RequestMapping("doIndexUI")//http://localhost:8080/doIndexUI
    public String doIndexUI() {

        return "starter";
        /**starter会返回给DispatcherServlet对象
         * DispatcherServlet会将viewname交给视图解析器
         * 视图解析器会在viewname的基础之上添加前缀和后缀.并进行解析
         * 视图解析器会将解析的结果返回给DispatcherServlet
         * DispatcherServlet会将结果响应到客户端
         * */

    }

    @RequestMapping("/log/log_list")
    public String doLogUI() {

        return "sys/log_list";
    }


    @RequestMapping("doPageUI")
    public String doPageUI() {

        return "common/page";
    }


}
