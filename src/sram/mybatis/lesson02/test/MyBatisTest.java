package sram.mybatis.lesson02.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import sram.mybatis.lesson02.pojo.Teacher;
import sram.mybatis.lesson02.util.DButils;

public class MyBatisTest {
	
	public static void main(String[] args) {
		
		List<Teacher> teacherList = null;
		SqlSession sqlSession = null;
		try {
			
			sqlSession = DButils.getSqlSession();
			//调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			teacherList = sqlSession.selectList("sram.mybatis.lesson02.pojo.Teacher.queryList");
			
			//lambda
			teacherList.forEach(teacher -> System.out.println(teacher.toString()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
}
