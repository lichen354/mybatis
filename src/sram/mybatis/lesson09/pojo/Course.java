package sram.mybatis.lesson09.pojo;

import org.apache.ibatis.type.Alias;

/**
 * 课程信息类--对应数据库中的course表
 * @author liche
 *
 */
public class Course {
	private String cno;
	private String cname;
	//封装关联对象
	private Teacher teacher;
	
	public Course() {
		
	}
	public Course(String cno, String cname, Teacher teacher) {
		super();
		this.cno = cno;
		this.cname = cname;
		this.teacher = teacher;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@Override
	public String toString() {
		return "Course [cno=" + cno + ", cname=" + cname + ", teacher=" + teacher + "]";
	}	
}
