package com.RandomFileTutorial;

import java.io.Serializable;

public class EmpRecordObj implements Serializable {
	private String id;
	private String fname;
	private String lname;
	private int age;
	private long tel;

	public EmpRecordObj() {
		this("", "", "", 0, 0);
	}

	public EmpRecordObj(String id, String fname, String lname, int age, long tel) {
		setId(id);
		setFname(fname);
		setLname(lname);
		setAge(age);
		setTel(tel);
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFname() {
		return fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLname() {
		return lname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	public long getTel() {
		return tel;
	}

	public String toString() {
		return ("Id=" + id + ", Fname=" + fname + ", Lname=" + lname + ", Age="
				+ age + ", Tel=" + tel);
	}
}
// to compile : javac -d . EmpRecordObj.java