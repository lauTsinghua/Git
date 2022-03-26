package com.cy.pj.common.config;


import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class SpringShiroConfig {
    /**
     * 配置shiro的核心对象：安全管理器
     **/
    @Bean//由此注解描述的方法会交给spring框架管理，默认bean的名字为方法名
    public SecurityManager securityManager(Realm realm, CacheManager cacheManager, RememberMeManager rememberMeManager, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm); //授权
        securityManager.setCacheManager(cacheManager);//  权限缓冲
        securityManager.setRememberMeManager(rememberMeManager);// 记住当前账户访问(一般为7天)
        securityManager.setSessionManager(sessionManager);//  会话时长
        return securityManager;

    }

    /**
     * 配置ShiroFilterFactoryBean对象，
     * 基于此对象创建的过滤器工厂，通过滤器工厂创建过滤器，通过过滤器对请求进行过滤
     ***/
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactory(SecurityManager securityManager) {
        ShiroFilterFactoryBean sBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        sBean.setSecurityManager(securityManager);
        //设置登陆页面url
        sBean.setLoginUrl("/doLoginUI");
        /**设置过滤规则**/
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //静态资源允许匿名访问：“anon”
        map.put("/bower_components/**", "anon");
        map.put("/build/**", "anon");
        map.put("/dist/**", "anon");
        map.put("/plugins/**", "anon");
        map.put("/user/doLogin", "anon");//登录
        map.put("/doLogout", "logout");//退出 ,有shiro框架提供
        map.put("/**", "user");//记住我的功能需要使用的功能
        //除了匿名访问的资源，其他都要认证（“authc”）后访问
        // map.put("/**", "authc");
        sBean.setFilterChainDefinitionMap(map);
        return sBean;
    }

    //==========================Shiro框架中授权配置===========================
//Shiro框架中授权配置是基于Spring框架
    @Bean
    public AuthorizationAttributeSourceAdvisor
    authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);

        return advisor;
    }

    //=========================非核心业务,做授权缓冲================================
    @Bean
    public CacheManager shiroCacheManaer() {
        return new MemoryConstrainedCacheManager();


    }

    //====================配置记住我=========================
    @Bean
    public RememberMeManager rememberMeManager() {
        CookieRememberMeManager cManager = new CookieRememberMeManager();
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        cookie.setMaxAge(7 * 24 * 3600);//记住我的时间范围: 一般为7天
        cManager.setCookie(cookie);
        return cManager;


    }

    //==========================会话时长的配置==========================
    @Bean
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(30 * 60 * 1000);  //会话时长默认30分钟
        return sessionManager;


    }

}
