package com.cy.pj.goods.service;

import com.cy.pj.goods.pojo.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestGoodsService {
    @Autowired
    private GoodsService goodsService;

    @Test
    public void testGoods() {
        for (Goods obeject : goodsService.findObejects()) {
            System.out.println(obeject);
        }


    }
}
