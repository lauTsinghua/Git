package com.cy.pj.sys.service.impl;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.ServiceNotFoundException;
import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public PageObject<SysLog> findPagesObject(String username, Long pageCurrent) {
        /**
         * 1.参数校验
         * 2.查询总记录数并校验
         * 3.查询当前页记录
         * 4.对查询的数据进行封装
         * */
        /*  1.参数校验*/
        if (pageCurrent == null || pageCurrent < 1) {
            throw new IllegalArgumentException("输入的页面不正确");
        }
        /*2.查询总记录数并校验*/
        long rowCount = sysLogDao.getRowCount(username);

        /*  3.查询当前页记录*/
        Integer pageSize = 10;
        long startIndex = (pageCurrent - 1) * pageSize;
        List<SysLog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);

        /* 4.对查询的数据进行封装*/
        return new PageObject<>(records, rowCount, pageCurrent, pageSize);

    }

    @Override
    public int deleteObjects(int... ids) throws ServiceNotFoundException {
        if (ids == null || ids.length < 1)
            throw new IllegalArgumentException("请先选择要删除的数据");
        int rows = sysLogDao.deleteObjects(ids);
        if (rows == 0)
            throw new ServiceNotFoundException("需要删除的数据可能已经不存在");
        return rows;
    }
}
