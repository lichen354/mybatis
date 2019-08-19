package sram.mybatis.lesson06.pojo;

import java.io.Serializable;

public class Teacher implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String Tno;
	private String Tname;
	public String getTno() {
		return Tno;
	}
	public void setTno(String tno) {
		Tno = tno;
	}
	public String getTname() {
		return Tname;
	}
	public void setTname(String tname) {
		Tname = tname;
	}
	@Override
	public String toString() {
		return "Teacher [Tno=" + Tno + ", Tname=" + Tname + "]";
	}
	
	
}
