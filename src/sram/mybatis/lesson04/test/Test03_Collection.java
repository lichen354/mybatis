package sram.mybatis.lesson04.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sram.mybatis.lesson04.util.DButils;
import sram.mybatis.lesson04.pojo.Student;

/**
 * 一对多关联查询
 * 主要利用 resultMap下的collection元素
 * @author liche
 *
 */
public class Test03_Collection {
	public static void main(String[] args) {
		//方式一： 嵌套结果
		testCollection01();
		
		//方式二： 嵌套查询
		//testCollection02();
	}
	
	public static void testCollection01() {
		List<Student> studentList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = DButils.getSqlSession();
			//调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			studentList = sqlSession.selectList("sram.mybatis.lesson04.pojo.Student.query");
			
			//lambda
			studentList.forEach(student -> System.out.println(student.toString()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	public static void testCollection02() {
		List<Student> studentList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = DButils.getSqlSession();
			//调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			studentList = sqlSession.selectList("sram.mybatis.lesson04.pojo.Student.query02");
			
			//lambda
			studentList.forEach(student -> System.out.println(student.toString()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
}
