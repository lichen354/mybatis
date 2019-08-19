package sram.mybatis.lesson06.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sram.mybatis.lesson06.pojo.Teacher;
import sram.mybatis.lesson06.util.DButils;

public class TestJunit {
private static Logger logger = Logger.getLogger(TestJunit.class);
	SqlSession sqlSession = null;
	@Before
	public void setUp() throws Exception {
		sqlSession = DButils.getSqlSession();
	}

	@Test
	public void test01() throws Exception{
		
		List<Teacher> teacherList = null;
		
		//调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
		teacherList = sqlSession.selectList("sram.mybatis.lesson06.pojo.Teacher.queryList");
		
		//lambda
		teacherList.forEach(teacher -> logger.info(teacher.toString()));
			
	}
	@After
	public void destory() {
		sqlSession.close();
	}
	
	public static void main(String[] args) {
		List<Teacher> teacherList = null;
		SqlSession sqlSession = null;
		try {
			
			sqlSession = DButils.getSqlSession();
			//调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			teacherList = sqlSession.selectList("sram.mybatis.lesson06.pojo.Teacher.queryList");
			
			//lambda
			teacherList.forEach(teacher -> logger.info(teacher.toString()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
}
