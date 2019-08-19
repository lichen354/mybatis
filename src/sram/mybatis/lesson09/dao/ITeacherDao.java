package sram.mybatis.lesson09.dao;

import org.apache.ibatis.annotations.Select;

import sram.mybatis.lesson09.pojo.Teacher;

public interface ITeacherDao {
	
	@Select("select * from teacher where Tno=#{tno}")
	Teacher getTeacher(String tno);
}
