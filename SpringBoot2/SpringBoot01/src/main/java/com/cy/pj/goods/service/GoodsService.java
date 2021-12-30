package com.cy.pj.goods.service;

import com.cy.pj.goods.pojo.GoodsPojo;

import java.util.List;

/**
 * 业务层 接口**/
public interface  GoodsService {
    List<GoodsPojo> findObejects();
    int deleteById(Long id);
    int saveGoods(GoodsPojo entity);
}
