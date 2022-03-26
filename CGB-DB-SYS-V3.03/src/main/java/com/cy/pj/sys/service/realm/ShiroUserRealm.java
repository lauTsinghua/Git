package com.cy.pj.sys.service.realm;

import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.dao.SysRoleMenuDao;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ShiroUserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;
    @Autowired
    private SysMenuDao sysMenuDao;


    /**
     * 负责获取用户权限信息并进行封装
     **/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        System.out.println("=======测试打印每次授权访问是否要重新访问这几张表==========");
        //1.获取登录用户身份信息
        SysUser user = (SysUser) principals.getPrimaryPrincipal();

        //2.基于用户id获取角色id
        List<Integer> roleIds =
                sysUserRoleDao.findRoleIdsByUserId(user.getId());
        if (roleIds == null || roleIds.size() == 0)
            throw new AuthorizationException();
        //3.基于角色id获取对应的菜单id
        List<Integer> menuIds =
                sysRoleMenuDao.findMenuIdsByRoleIds(roleIds.toArray(new Integer[]{}));
        if (menuIds == null || menuIds.size() == 0)
            throw new AuthorizationException();
        //4.基于菜单id获取授权标识

        List<String> permissions = sysMenuDao.findPermissions(menuIds.toArray(new Integer[]{}));
        if (permissions == null || permissions.size() == 0)
            throw new AuthorizationException();

        //5.对用户权限信息进行封装
        Set<String> stringPermissions = new HashSet<>();  //权限去重
        for (String per : permissions) {
            if (!StringUtils.isEmpty(per))
                stringPermissions.add(per);
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(stringPermissions);
        return info;  //返回给授权管理器
    }

    /**
     * 设置凭证匹配器(与用户添加操作使用相同的加密算法)
     **/
    /*@Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        //构建凭证匹配对象
        HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
        //设置加密算法
        cMatcher.setHashAlgorithmName("MD5");
        //设置加密次数
        cMatcher.setHashIterations(1);
        super.setCredentialsMatcher(cMatcher);
    }
*/

    /**
     * 设置凭证匹配器(与用户添加操作使用相同的加密算法)
     **/
    @Override
    public CredentialsMatcher getCredentialsMatcher() {// 与set方法效果一样
        //构建凭证匹配对象
        HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
        //设置加密算法
        cMatcher.setHashAlgorithmName("MD5");
        //设置加密次数
        cMatcher.setHashIterations(1);

        return cMatcher;
    }

    /**
     * 该方法用于负责认证信息的获取以及封装
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken
                                                                 token) throws AuthenticationException {
        //1.获取登录用户信息（页面上用户输入的用户名）
        UsernamePasswordToken uToken = (UsernamePasswordToken) token;
        //2.基于用户名查询数据库获取用户对象信息并进行判断
        String username = uToken.getUsername();
        //2.1获取用户对象
        SysUser user = sysUserDao.findUserByUserName(username);
        //2.2验证对象是否存在
        if (user == null)
            throw new UnknownAccountException();
        //2.3检查用户是否被禁用
        if (user.getValid() == 0) throw new LockedAccountException();
        //3.封装用户信息并返回
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt().getBytes());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user,//用户身份
                user.getPassword(), //加密的密码
                credentialsSalt, // 盐值
                this.getName() // realm的名字
        );
        return info;//返回给认证管理器
    }
}
