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
   private  GoodsDao goodsDao ;

    @Override
    public List<Goods> findObjects() {
        List<Goods> list = goodsDao.findObejects();
        return list ;
    }

    @Override
    public int deleteById(Long id) {
        int rows = goodsDao.deleteById(id);
        return rows;
    }

    @Override
    public int insertObjects(Goods entity) {
        int rows = goodsDao.insertObjects(entity);
        return rows;
    }
}
