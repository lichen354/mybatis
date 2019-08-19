package sram.mybatis.lesson01.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import sram.mybatis.lesson01.pojo.Teacher;
/**
 * 虽然不推荐使用这种方式， 但是我们还是谈谈如何使用它。通过代码来实现与 XML
 * 相同的功能-----创建 SqlSessionFactory
 * @author liche
 *
 */
public class MybatisTestWithJava {
	
	//创建 SqlSessionFactory
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
		configuration.addMappers("XXX.class");
		//使用SqlSessionFactoryBuilder构建SqlSessionFactory
		SqlSessionFactory SqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		return SqlSessionFactory;
	}
	
	
	public static void main(String[] args) {
		//数据库连接池信息 
	
	
	
		List<Teacher> teacherList = null;
		SqlSessionFactory  sqlSessionFactory = null;
		SqlSession sqlSession = null;
		
		try {
			sqlSessionFactory = getSqlSession();
			sqlSession = sqlSessionFactory.openSession();
			//调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			teacherList = sqlSession.selectList("sram.mybatis.lesson01.pojo.Teacher.queryList");
			
			//lambda
			teacherList.forEach(teacher -> System.out.println(teacher.toString()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
}
