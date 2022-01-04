package com.cy.pj.sys.service.impl;

import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

}

