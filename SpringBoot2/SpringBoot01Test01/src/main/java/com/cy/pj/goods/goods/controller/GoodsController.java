package com.cy.pj.goods.goods.controller;


import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/goods/")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("doGoodsUI") //url=http://localhost:8080//goods/doGoodsUI
    public String doGoodsUI(Model model) {//向模型添加属性
        List<Goods> list = goodsService.findObjects();
        model.addAttribute("goods", list);
        return "goods";//返回给调用方，在这里是Dispatcherservlet

    }

    @RequestMapping("doDeleteById") //http://localhost:8080//goods/doDeleteById
    public String deleteById(Long id) {
        goodsService.deleteById(id);
        return "redirect:doGoodsUI";
    }

    @RequestMapping("doSaveGoods")
    public String doSaveGoods(Goods entity) {
        goodsService.insertObjects(entity) ;
        return "redirect:doGoodsUI";
    }


}
