package sram.mybatis.lesson04.pojo;

import java.util.Date;
import java.util.List;

public class Student {
	private String sno;
	private String sname;
	private Date sbirth;
	private String ssex;
	
	//成绩
	private List<Score> score_list;
	
	public Student() {
		
	}
	
	public Student(String sno, String sname, Date sbirth, String ssex) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sbirth = sbirth;
		this.ssex = ssex;
	}
	public Date getSbirth() {
		return sbirth;
	}

	public void setSbirth(Date sbirth) {
		this.sbirth = sbirth;
	}

	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	public List<Score> getScore_list() {
		return score_list;
	}

	public void setScore_list(List<Score> score_list) {
		this.score_list = score_list;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sbirth=" + sbirth + ", ssex=" + ssex + ", score_list="
				+ score_list + "]";
	}
	
	
	
	
}
