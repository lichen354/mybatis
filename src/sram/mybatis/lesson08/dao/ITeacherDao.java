package sram.mybatis.lesson08.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import sram.mybatis.lesson08.pojo.Teacher;

public interface ITeacherDao {
	
	@Select("select Tno,Tname from teacher")
	public List<Teacher> queryList();
}
