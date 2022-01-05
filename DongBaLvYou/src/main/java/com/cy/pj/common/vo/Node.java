package com.cy.pj.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Node implements Serializable {
    private static final long serialVersionUID = 0b111111111111111111111111111111;
    private Integer id;
    private String name;
    private Integer parentId;


}
