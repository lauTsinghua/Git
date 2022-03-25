package com.cy.pj.sys.service.realm;

import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.entity.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

@Service
public class ShiroUserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
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
        return info;//返回给认证管理
    }
}
