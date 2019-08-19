package sram.mybatis.lesson08.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sram.mybatis.lesson08.dao.IStudentDao;
import sram.mybatis.lesson08.dao.ITeacherDao;
import sram.mybatis.lesson08.pojo.Student;
import sram.mybatis.lesson08.pojo.Teacher;
import sram.mybatis.lesson08.util.DButils;
/**
 * mybatis注解开发
 * @author liche
 *
 */
public class MyBatisTest {
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
	 * 查询
	 */
	@Test
	public void testQuery() {
		List<Teacher> teacherList = null;
		
	    //使用SqlSession创建Dao接口的代理对象
		ITeacherDao iTeacherDao = sqlSession.getMapper(ITeacherDao.class);
		teacherList = iTeacherDao.queryList();	
		//lambda
		teacherList.forEach(teacher -> System.out.println(teacher.toString()));
	}
	
	/*
	 * 新增
	 */
	@Test
	public void testSaveStudent() throws ParseException {
		
		Student s = new Student("123","小强","2012-12-12 12:12:12","男");
		IStudentDao iStudentDao = sqlSession.getMapper(IStudentDao.class);
		int res = iStudentDao.save(s);
		sqlSession.commit();
		System.out.println(res);
	}
	
	/*
	 * 修改
	 */
	@Test
	public void testUpdateStudent() throws ParseException {
		
		Student s = new Student("123","小强","2012-12-12 12:12:12","女");
		IStudentDao iStudentDao = sqlSession.getMapper(IStudentDao.class);
		int res = iStudentDao.update(s);
		sqlSession.commit();
		System.out.println(res);
	}
	
	/*
	 * 删除
	 */
	@Test
	public void testDeleteStudent() throws ParseException {
		
		Student s = new Student("123","小强","2012-12-12 12:12:12","女");
		IStudentDao iStudentDao = sqlSession.getMapper(IStudentDao.class);
		int res = iStudentDao.delete(s);
		sqlSession.commit();
		System.out.println(res);
	}
}
