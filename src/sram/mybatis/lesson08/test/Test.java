package sram.mybatis.lesson08.test;

import java.util.List;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import sram.mybatis.lesson08.pojo.Teacher;
import sram.mybatis.lesson08.dao.ITeacherDao;

public class Test {
	public static SqlSessionFactory getSqlSession() {
		PooledDataSource dataSource =new PooledDataSource ();
		dataSource.setDriver("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("mysql");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/example?useUnicode=true&characterEncoding=utf-8");
		dataSource.setDefaultAutoCommit(false);
		//采用MyBatis的JDBC事务方式
		TransactionFactory transactionFactory =new JdbcTransactionFactory() ;
		Environment environment =new Environment("development",transactionFactory,dataSource); 
		//创建 Configuration 对象 
		Configuration configuration= new Configuration(environment);
		//注册一个MyBatis上下文别名
		configuration.getTypeAliasRegistry().registerAlias("teacher",Teacher.class);
		//加入一个映射器
		configuration.addMapper(ITeacherDao.class);
		//使用SqlSessionFactoryBuilder构建SqlSessionFactory
		SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		return SqlSessionFactory;
	}
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = getSqlSession();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Teacher> teacherList = null;
		
		
		
	    //使用SqlSession创建Dao接口的代理对象
		ITeacherDao iTeacherDao = sqlSession.getMapper(ITeacherDao.class);
		teacherList = iTeacherDao.queryList();	
		//lambda
		teacherList.forEach(teacher -> System.out.println(teacher.toString()));
	}
}
