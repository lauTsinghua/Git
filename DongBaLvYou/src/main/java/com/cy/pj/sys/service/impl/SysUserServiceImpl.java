package com.cy.pj.sys.service.impl;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysUserDao;
import com.cy.pj.sys.dao.SysUserRoleDao;
import com.cy.pj.sys.entity.SysUser;
import com.cy.pj.sys.service.SysUserService;
import com.cy.pj.sys.vo.SysUserDeptVo;
import lombok.Value;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.thymeleaf.util.StringUtils;
import sun.java2d.pipe.SpanShapeRenderer;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public Map<String, Object> findObjectById(Long id) {
        //1.参数校验
        if(id ==null||id<1){
            throw new IllegalArgumentException("当前ID值无效");
        }

        //2.基于ID进行查询

        SysUserDeptVo user = sysUserDao.findObjectById(id);
        if (user==null){
            throw new ServiceException("当前记录可能已经不存在") ;
        }
        List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(id);
        HashMap<String, Object> map = new HashMap<>();
        map.put("user",user);
        map.put("roleIds",roleIds) ;
        return map;
    }

    @Override
    public PageObject<SysUserDeptVo> findPageObjects(String username, Long pageCurrent) {
        //1.参数校验
        if (pageCurrent == null || pageCurrent < 1)
            throw new IllegalArgumentException("当前页码值无效");
        //2.查询总记录数并校验
        long rowCount = sysUserDao.getRowCount(username);
        if (rowCount == 0)
            throw new ServiceException("记录不存在");
        //3.查询当前页记录
        int pageSize = 3;
        long startIndex = (pageCurrent - 1) * pageSize;
        List<SysUserDeptVo> records =
                sysUserDao.findPageObjects(username, startIndex, pageSize);
        //4.封装查询结果
        return new PageObject<>(records, rowCount, pageSize, pageCurrent);
    }

    @Override
    public int validById(Long id, Integer valid) {
        int rows = sysUserDao.validById(id, valid, "admin");

        return rows;
    }

    @Override
    public int saveObject(SysUser entity, Integer[] roleIds) {
//1.参数校验
        if (entity == null)
            throw new IllegalArgumentException("保存对象不能为空");

        if (StringUtils.isEmpty(entity.getUsername()))
            throw new IllegalArgumentException("用户名不能为空");
        if (StringUtils.isEmpty(entity.getPassword()))
            throw new IllegalArgumentException("密码不能为空");
        if (roleIds == null || roleIds.length == 0)
            throw new ServiceException("必须为用户指定的角色");
// 2.保存用户信息
//2.1对密码进行加密(MD5加密)
        String salt = UUID.randomUUID().toString();
        /**
         * 一种消息摘要的加密,该加密不可逆
         *相同的加密内容加密的结果相同
         * String hashedPassword = DigestUtils.md5DigestAsHex((salt+entity.getPassword()).getBytes());*/
        //第三方加密
        SimpleHash simpleHash = new SimpleHash("MID5", entity.getPassword(), salt, 1);
        String hashedPassword = simpleHash.toHex();//转化为16进制
        entity.setSalt(salt);
        entity.setPassword(hashedPassword);
// 2.2保存用户对象
        int rows = sysUserDao.insertObject(entity);
//3.保存用户和角色关系数据
        sysUserRoleDao.insertObject(entity.getId(), roleIds);

// 4.返回结果


        return rows;
    }
    @Override
    public int updateObject(SysUser entity, Integer[] roleIds) {
//1.参数校验
        if (entity == null)
            throw new IllegalArgumentException("保存对象不能为空");

        if (StringUtils.isEmpty(entity.getUsername()))
            throw new IllegalArgumentException("用户名不能为空");

        if (roleIds == null || roleIds.length == 0)
            throw new ServiceException("必须为用户指定的角色");
// 2.保存用户信息

        int rows = sysUserDao.updateObject(entity);
//3.保存用户和角色关系数据
        /**先删除原有数据,在添加新数据,从而实现更新的功能**/
        sysUserRoleDao.deleteObjectsByUserId(entity.getId());

        sysUserRoleDao.insertObject(entity.getId(), roleIds);

// 4.返回结果


        return rows;
    }

}
