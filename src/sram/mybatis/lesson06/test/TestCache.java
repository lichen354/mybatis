package sram.mybatis.lesson06.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import sram.mybatis.lesson06.pojo.Teacher;
import sram.mybatis.lesson06.util.DButils;

/**
 * myBatis缓存
 * 
 * Mybatis对缓存提供支持，默认开启一级缓存
 * 
 * 一级缓存只是相对于同一个SqlSession而言
 * 二级缓存是Application级别的缓存，它可以提高对数据库查询的效率，以提高应用的性能。
 * 只需要在你的 SQL 映射文件中添加一行：
 * <cache/>
 * 
 * @author liche
 *
 */
public class TestCache {
	SqlSession sqlSession = null;
	SqlSession sqlSession1 = null;
	@Before
	public void setUp() throws Exception {
		sqlSession = DButils.getSqlSession();
		sqlSession1 = DButils.getSqlSession();
	}
	@After
	public void destory() {
		sqlSession.close();
		sqlSession1.close();
	}
	/**
	 * 测试一级缓存
	 * 默认开启
	 */
	@Test
	public void testCacheL1() throws Exception{
		List<Teacher> teacherList = null;
		teacherList = sqlSession.selectList("sram.mybatis.lesson06.pojo.Teacher.queryList");
		// 进行相同的查询操作
		teacherList = sqlSession.selectList("sram.mybatis.lesson06.pojo.Teacher.queryList");
		teacherList = sqlSession.selectList("sram.mybatis.lesson06.pojo.Teacher.queryList");
		System.out.println("\n\n=============================================================");
		
		//使用另一个sqlSession
		teacherList = sqlSession1.selectList("sram.mybatis.lesson06.pojo.Teacher.queryList");
	}
	/**
	 * 测试二级缓存
	 * 	<cache/>
	 * 	pojo序列化
	 */
	@Test
	public void testCacheL2() {
		List<Teacher> teacherList = null;
		teacherList = sqlSession.selectList("sram.mybatis.lesson06.pojo.Teacher.queryList");
		// 进行相同的查询操作
		teacherList = sqlSession.selectList("sram.mybatis.lesson06.pojo.Teacher.queryList");
		teacherList = sqlSession.selectList("sram.mybatis.lesson06.pojo.Teacher.queryList");
		// 注意，当我们使用二级缓存时候，sqlSession需要使用commit时候才会生效
        sqlSession.commit();
		System.out.println("\n\n=============================================================");
		
		//使用另一个sqlSession
		teacherList = sqlSession1.selectList("sram.mybatis.lesson06.pojo.Teacher.queryList");
	}
}
