package com.cy.pj.goods.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @RequestMapping("/doGoodsUI")
    public String doGoodsUI(){
     return "goods"   ;
    }
}
