package com.cy.pj.sys.dao;

import com.cy.pj.sys.entity.SysLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysLogDaoTests {

	  //@Resource
	  @Autowired
	  private SysLogDao sysLogDao;
	  @Test
	  public void testGetRowCount() {
		  long rowCount=
		  sysLogDao.getRowCount("admin");
		  System.out.println("rowCount="+rowCount);
	  }
	  @Test
	  public void testFindPageObjects() {
		  List<SysLog> list=
		  sysLogDao.findPageObjects("xiao",0, 5);
		  for(SysLog log:list) {
			  System.out.println(log);
		  }
	  }
}
