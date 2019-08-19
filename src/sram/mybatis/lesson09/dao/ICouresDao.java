package sram.mybatis.lesson09.dao;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import sram.mybatis.lesson09.pojo.Course;

public interface ICouresDao {
	
	/*
	 * 
	 */
	@Select("select * from course")
	@Results({
		@Result(column="Cno", property="cno", javaType=String.class, jdbcType=JdbcType.VARCHAR),
		@Result(column="Cname", property="cname", javaType=String.class, jdbcType=JdbcType.VARCHAR),
		@Result(column="Tno", property="teacher", one=@One(select="sram.mybatis.lesson09.dao.ITeacherDao.getTeacher"))
	})
	List<Course> queryList();
}
