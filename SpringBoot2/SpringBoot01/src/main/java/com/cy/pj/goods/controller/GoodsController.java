package com.cy.pj.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @RequestMapping("/doGoodsUI") //url=http://localhost:8080//goods/doGoodsUI
    public String doGoodsUI(){
     return "goods";//返回给调用方，在这里是Dispatcherservlet
/**
 * DispatcherServlet会将goods字符串交给视图解析器对象(thymeleaf提供)
 * thymeleaf中的视图解析器会对goods字符串添加前缀和后缀
 * **/

    }
}
