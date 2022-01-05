package com.cy.pj.common.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 借助此对象封装数据层返回的分页查询结果，并计算分析信息
 */

@Data
@NoArgsConstructor
public class PageObject<T> implements Serializable {
    private static final long serialVersionUID = 0b1111111111111111111111111111111;

    /**
     * 封装查询到的当前页的记录
     **/
    private List<T> records;
    /**
     * 总记录数
     */
    private Long rowCount;
    /**
     * 总页数
     */
    private Long pageCount;
    /**
     * 页面大小
     */
    private Integer pageSize;
    /**
     * 当前页码值
     */
    private Long pageCurrent;


    public PageObject(List<T> records, Long rowCount, Long pageCurrent, Integer pageSize) {
        super();
        this.records = records;
        this.rowCount = rowCount;
        this.pageSize = pageSize;
        this.pageCurrent = pageCurrent;
        //this.pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);//计算总页数
        this.pageCount = (rowCount - 1) / pageSize + 1;//计算总页数
    }
}
