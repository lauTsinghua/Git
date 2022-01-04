package com.cy.pj.sys.controller;


import com.cy.pj.sys.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Slf4j
@Controller
public class SysLogController {

    @Autowired
    private SysLogService service;

}
