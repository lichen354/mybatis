package sram.mybatis.lesson09.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sram.mybatis.lesson09.dao.ICouresDao;
import sram.mybatis.lesson09.dao.IStudentDao;
import sram.mybatis.lesson09.dao.ITeacherDao;
import sram.mybatis.lesson09.pojo.Course;
import sram.mybatis.lesson09.pojo.Student;
import sram.mybatis.lesson09.pojo.Teacher;
import sram.mybatis.lesson09.util.DButils;
/**
 * 使用mybatis注解实现一对一查询，一对多查询
 * @author liche
 *
 */
public class MybatisTest09 {
	
	
private SqlSession sqlSession = null;
	
	@Before
	public void init() throws IOException {
		sqlSession = DButils.getSqlSession();
	}
	
	@After
	public void close() {
		sqlSession.close();
		System.out.println("sqlSession closed");
	}
	/*
	 * 一对一  
	 */
	@Test
	public void testAssociation() {
		List<Course> courseList = null;
		
	    //使用SqlSession创建Dao接口的代理对象
		ICouresDao iCouresDao = sqlSession.getMapper(ICouresDao.class);
		courseList = iCouresDao.queryList();	
		//lambda
		courseList.forEach(course -> System.out.println(course.toString()));
	}
	/*
	 * 一对多
	 */
	@Test
	public void testCollection() {
		List<Student> studentList = null;
		
	    //使用SqlSession创建Dao接口的代理对象
		IStudentDao iStudentDao = sqlSession.getMapper(IStudentDao.class);
		studentList = iStudentDao.queryList();	
		//lambda
		studentList.forEach(s -> System.out.println(s));
	}
	
}
