package sram.mybatis.lesson09.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import sram.mybatis.lesson09.pojo.Score;

public interface IScoreDao {
	@Select("select * from score where sno=#{sno}")
	List<Score> queryList(String sno);
}
