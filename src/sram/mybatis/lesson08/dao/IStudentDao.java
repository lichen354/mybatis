package sram.mybatis.lesson08.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import sram.mybatis.lesson08.pojo.Student;

public interface IStudentDao {
	
	/*
	 * insert注解
	 * mysql 日期格式转换 STR_TO_DATE(str,formate)
	 * 方法返回修改的记录条数
	 */
	@Insert("insert into student(Sno,Sname,Sage,Ssex) "
			+ "values(#{sno},#{sname},STR_TO_DATE(#{birth},'%Y-%m-%d %H:%i:%s'),#{ssex})")
	int save(Student student);
	
	/*
	 * update注解
	 */
	@Update("update student set Sname=#{sname}, Sage=#{birth}, Ssex=#{ssex}"
			+ "where Sno=#{sno}")
	int update(Student student);
	
	@Delete("delete from student where Sno=#{sno}")
	int delete(Student student);
}
