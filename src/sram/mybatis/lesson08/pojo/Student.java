package sram.mybatis.lesson08.pojo;

import java.sql.Date;

public class Student {
	private String sno;
	private String sname;
	private String birth;
	private String ssex;
	
	public Student() {
		
	}
	
	public Student(String sno, String sname, String birth, String ssex) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.birth = birth;
		this.ssex = ssex;
	}
	
	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
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
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", birth=" + birth + ", ssex=" + ssex + "]";
	}
	
	
	
}
