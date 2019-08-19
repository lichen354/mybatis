package sram.mybatis.lesson04.pojo;

import java.math.BigDecimal;

/**
 * 成绩信息类--对象数据库中score表
 * @author liche
 *
 */
public class Score {
	private String sno;
	private String cno;
	private BigDecimal score;
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public BigDecimal getScore() {
		return score;
	}
	public void setScore(BigDecimal score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Score [sno=" + sno + ", cno=" + cno + ", score=" + score + "]";
	}
	
	
}
