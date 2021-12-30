package com.cy.pj.goods.controller;

import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsContoller {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/doGoodsUI") //url=http://localhost:8080//goods/doGoodsUI
    public String doGoodsUI(Model model){
        List<Goods> list = goodsService.findAll();
        model .addAttribute("goods",list );
        return "goods";
    }
}
