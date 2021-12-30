package com.cy.pj.goods.service.impl;

import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.pojo.Goods;
import com.cy.pj.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao ;
    @Override
    public List<Goods> findAll() {
        long start=System .currentTimeMillis();
        List<Goods> list = goodsDao.findAll();
        long end=System .currentTimeMillis();
        System.out.println("Time="+(end-start));
        return list;
    }
}
