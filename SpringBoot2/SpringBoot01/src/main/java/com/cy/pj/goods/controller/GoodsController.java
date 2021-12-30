package com.cy.pj.goods.controller;




/**
 * 课堂练习:
 * 练习一:将数据库中的商品数据查询出来更新到页面上。
 * 练习二:基于ID删商品库中的商品信息。
 * 练习三:将页面用户输入的商品信息写入到数据库。
 **/

import com.cy.pj.goods.pojo.GoodsPojo;
import com.cy.pj.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/***控制层***/
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/doDeleteById") //http://localhost:8080//goods/doDeleteById?id=8
    public String deleteById(Long id) {
        goodsService.deleteById(id);
        return "redirect:/goods/doGoodsUI";
    }


    @RequestMapping("/doGoodsUI") //url=http://localhost:8080//goods/doGoodsUI
    public String doGoodsUI(Model model) {//向模型添加属性

        List<GoodsPojo> list = goodsService.findObejects();
        model.addAttribute("goods", list);
        return "goods";//返回给调用方，在这里是Dispatcherservlet
/**
 * DispatcherServlet会将goods字符串交给视图解析器对象(thymeleaf提供)
 * thymeleaf中的视图解析器会对goods字符串添加前缀和后缀
 * **/
    }

    @RequestMapping("/doSaveGoods")
    public String doSaveGoods(GoodsPojo entity) {
        goodsService.saveGoods(entity);
        return "redirect:/goods/doGoodsUI";
    }


}
