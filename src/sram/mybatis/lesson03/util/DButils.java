package sram.mybatis.lesson03.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DButils {
	private static final String RESOURCE = "sram\\mybatis\\lesson03\\mybatis-config.xml";
	private static SqlSessionFactory factory = null;
	
	
	public static SqlSession getSqlSession() throws IOException{
		if(factory == null){
			Reader reader = Resources.getResourceAsReader(RESOURCE);
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}
		SqlSession sqlSession = factory.openSession();
		return sqlSession;
	}
	/*指定environment (数据源)*/
	public static SqlSession getSqlSession(String environment) throws IOException{
		if(factory == null){
			Reader reader = Resources.getResourceAsReader(RESOURCE);
			factory = new SqlSessionFactoryBuilder().build(reader, environment);
			reader.close();
		}
		SqlSession sqlSession = factory.openSession();
		return sqlSession;
	}
}