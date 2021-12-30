package com.cy.pj.goods.service.impl;

import com.cy.pj.goods.dao.GoodsDao;
import com.cy.pj.goods.pojo.GoodsPojo;
import com.cy.pj.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * 实现业务层的接口
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<GoodsPojo> findObejects() {
        long start = System.currentTimeMillis();
        List<GoodsPojo> list = goodsDao.findObejects();
        long end = System.currentTimeMillis();
        System.out.println("Query time:" + (end - start));
        return list;
    }

    @Override
    public int deleteById(Long id) {
        if (id == null || id < 1)
            throw new IllegalArgumentException("输入的id格式不正确");
        else if (goodsDao.deleteById(id) == 0)
            throw new NoSuchElementException("输入的id可能已经不存在");
        else
            return goodsDao.deleteById(id);

    }
}

