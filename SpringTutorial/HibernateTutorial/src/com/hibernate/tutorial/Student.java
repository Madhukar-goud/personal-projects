package com.hibernate.tutorial;

public class Student {
	
	private String studentName;
	private int id;
	private String courseName;
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", id=" + id
				+ ", courseName=" + courseName + "]";
	}
	
	

}
