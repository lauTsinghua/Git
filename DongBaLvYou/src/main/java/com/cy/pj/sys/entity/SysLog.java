package com.cy.pj.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
/*只要用于存储对象的数据,我们都让他实现序列化接口*/
public class SysLog implements Serializable {
    private static final long serialVersionUID = 0b1111111111111111111111111111111;
    private Integer id;
    private String username;
    /**
     * 用户名
     */
    private String operation;
    /**
     * 用户操作
     */
    private String method;
    /**
     * 请求方法
     */
    private String params;
    /**
     * 请求参数
     */
    private Long time;
    /**
     * 执行时间
     */
    private String ip;
    /**
     * ip地址
     */
    private Date createdTime;/**创建时间*/

}
