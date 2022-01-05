package com.cy.pj.sys.service.impl;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.dao.SysMenuDao;
import com.cy.pj.sys.entity.SysMenu;
import com.cy.pj.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public List<Map<String, Object>> findObjects() {
        return sysMenuDao.findObjects();

    }

    @Override
    public List<Node> findZtreeMenuNodes() {
        return sysMenuDao.findZtreeMenuNodes();
    }

    @Override
    public int deleteobject(Integer id) {
        int rows = sysMenuDao.deleteobject(id);
        return rows;
    }

    @Override
    public int saveObject(SysMenu entity) {
        if (entity == null)
            throw new IllegalArgumentException("保存对象不能为空");
        int rows = sysMenuDao.insertObject(entity);
        return rows;
    }

    @Override
    public int updateObject(SysMenu entity) {
        if (entity == null)
            throw new IllegalArgumentException("修改对象不能为空");
        int rows = sysMenuDao.updateObject(entity);
        return rows;
    }
}
