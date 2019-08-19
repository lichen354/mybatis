package sram.mybatis.lesson09.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import sram.mybatis.lesson09.pojo.Student;

public interface IStudentDao {
	
	@Select("select * from student")
	@Results({
		@Result(column="Sno", property="sno", javaType=String.class, jdbcType=JdbcType.VARCHAR),
		@Result(column="Sname", property="sname", javaType=String.class, jdbcType=JdbcType.VARCHAR),
		@Result(column="Sbirth", property="sbirth", javaType=Date.class, jdbcType=JdbcType.DATE),
		@Result(column="Ssex", property="ssex", javaType=String.class, jdbcType=JdbcType.VARCHAR),
		@Result(property="score_list", javaType=List.class, column="Sno", many=@Many(select="sram.mybatis.lesson09.dao.IScoreDao.queryList"))
	})
	List<Student> queryList();
}
