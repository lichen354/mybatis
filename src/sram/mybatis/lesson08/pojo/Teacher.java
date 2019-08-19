package sram.mybatis.lesson08.pojo;

public class Teacher {
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
