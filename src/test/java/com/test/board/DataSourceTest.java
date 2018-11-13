package com.test.board;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/myba/contextConfig.xml")
public class DataSourceTest {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testMybatis() {
		try(SqlSession session = sqlSessionFactory.openSession();
			Connection con = session.getConnection();) {
			System.out.println(session);
			System.out.println(con);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}

}
