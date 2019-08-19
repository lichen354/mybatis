package sram.mybatis.lesson03.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import sram.mybatis.lesson03.pojo.Teacher;
import sram.mybatis.lesson03.util.DButils;
/**
 * lesson03 CRUD操作
 * @author liche
 *
 */
public class MyBatisTest {
	
	public static void main(String[] args) {
		List<Teacher> teacherList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = DButils.getSqlSession();
			//调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			teacherList = sqlSession.selectList("sram.mybatis.lesson03.pojo.Teacher.queryList");
			
			//lambda
			teacherList.forEach(teacher -> System.out.println(teacher.toString()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	
}
