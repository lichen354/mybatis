package sram.mybatis.lesson04.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import sram.mybatis.lesson04.pojo.Teacher;
import sram.mybatis.lesson04.util.DButils;
/**
 * lesson04
 * 强大的resultMap元素
 * 
 * @author liche
 *
 */
public class Test01_ResultMap {
	public static void main(String[] args) {
		//测试resultMap
		testSimple();
	}
	
	public static void testSimple() {
		List<Teacher> teacherList = null;
		SqlSession sqlSession = null;
		try {
			sqlSession = DButils.getSqlSession();
			//调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
			teacherList = sqlSession.selectList("sram.mybatis.lesson04.pojo.Teacher.queryList");
			
			//lambda
			teacherList.forEach(teacher -> System.out.println(teacher.toString()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	
}
