package com.cy.pj.goods.service;

import com.cy.pj.goods.pojo.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> findObjects();
    int deleteById(Long id);
    int insertObjects(Goods entity);
}
