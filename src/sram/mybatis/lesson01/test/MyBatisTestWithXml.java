package sram.mybatis.lesson01.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import sram.mybatis.lesson01.pojo.Teacher;

public class MyBatisTestWithXml {
	
	public static void main(String args[]) {
		String resource = "sram\\mybatis\\lesson01\\mybatis-config.xml";
		List<Teacher> teacherList = null;
		SqlSession sqlSession = null;
		try {
			//1 获取mybatis-config.xml的输入流
			InputStream is = Resources.getResourceAsStream(resource);
			//2 创建SqlSessionFactory对象，完成对配置文件的读取
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			//3 创建sqlSession
			sqlSession = factory.openSession();
			//4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			teacherList = sqlSession.selectList("sram.mybatis.lesson01.pojo.Teacher.queryList");
			
			//lambda
			teacherList.forEach(teacher -> System.out.println(teacher.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}	
}
