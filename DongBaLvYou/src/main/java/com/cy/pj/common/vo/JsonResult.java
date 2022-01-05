package com.cy.pj.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 借助此对象封装控制层返回客户端数据:要求这些数据必须有状态信息
 **/
@Data
@NoArgsConstructor
public class JsonResult implements Serializable {
    private static final long serialVersinUID = 0b1111111111111111111111111111111;

    private int state = 1;
    private String message = "ok";
    private Object data;

    public JsonResult(String message) {

        this.data = data;
    }

    public JsonResult(Object data) {

        this.data = data;
    }

    public JsonResult(Throwable e) {

        this.state = 0;
        this.message = e.getMessage();
    }


}
