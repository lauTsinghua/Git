package com.cy.pj.common.util;

import com.cy.pj.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
/**抓取用户ID的名字**/
public class ShiroUtils {


    public static String getUsername() {
        return getUser().getUsername();
    }

    public static SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }


}
