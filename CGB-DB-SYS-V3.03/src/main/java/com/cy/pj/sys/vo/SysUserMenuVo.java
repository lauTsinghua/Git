package com.cy.pj.sys.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
@Data
public class SysUserMenuVo implements Serializable  {

    private static final long serialVersionUID = -7213694248989299601L;
    private Integer id;
    private String name;
    private String url;
    private List<SysUserMenuVo> childs;//二级菜单


}
