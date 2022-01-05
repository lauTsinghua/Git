package com.cy.pj.sys.service;


import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;

import javax.management.ServiceNotFoundException;

public interface SysLogService {

    /**
     * 基于条件进行日志信息的分页查询操作
     * param username查询条件
     * param pageCurrent 当前页码值
     * return当虑页记录
     */

    PageObject<SysLog> findPagesObject(
            String username, Long pageCurrent
    );

    int deleteObjects(int... ids) throws ServiceNotFoundException;
}
