package sram.mybatis.lesson04.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sram.mybatis.lesson04.pojo.Course;
import sram.mybatis.lesson04.util.DButils;
/**
 * 一对一 关联查询
 * 主要利用resultMap下的association元素
 * @author liche
 *
 */
public class Test02_Association {
	public static void main(String[] args) {
		//方式一： 嵌套结果
		//testAssociation01();
		
		//方式二： 嵌套查询
		testAssociation02();
	}
	
	public static void testAssociation01() {
		List<Course> courseList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = DButils.getSqlSession();
			//调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			courseList = sqlSession.selectList("sram.mybatis.lesson04.pojo.Course.query01");
			
			//lambda
			courseList.forEach(course -> System.out.println(course.toString()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	public static void testAssociation02() {
		List<Course> courseList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = DButils.getSqlSession();
			//调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			courseList = sqlSession.selectList("sram.mybatis.lesson04.pojo.Course.query02");
			
			//lambda
			courseList.forEach(course -> System.out.println(course.toString()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
}
