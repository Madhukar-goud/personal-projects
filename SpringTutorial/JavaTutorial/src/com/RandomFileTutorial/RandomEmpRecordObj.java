package com.RandomFileTutorial;

import java.io.RandomAccessFile;
import java.io.IOException;

public class RandomEmpRecordObj extends EmpRecordObj {
	/**
	 * Size of this object. id, fname,lname each 15 * 2 bytes=90 bytes. age 4
	 * bytes, tel 8 bytes. Total is 90+4+8=102 bytes.
	 */
	public static final int SIZE = 102;
	private final int FIELD_SIZE = 15;

	public RandomEmpRecordObj() {
		this("", "", "", 0, 0);
	}

	public RandomEmpRecordObj(String id, String fname, String lname, int age,
			long tel) {
		super(id, fname, lname, age, tel);
	}

	public void write(RandomAccessFile f) throws IOException {
		writeName(f, getId());
		writeName(f, getFname());
		writeName(f, getLname());
		f.writeInt(getAge());
		f.writeLong(getTel());
	}

	public void read(RandomAccessFile f) throws IOException {
		setId(readName(f));
		setFname(readName(f));
		setLname(readName(f));
		setAge(f.readInt());
		setTel(f.readLong());
	}

	private void writeName(RandomAccessFile f, String name) throws IOException {
		StringBuffer sbf = null;
		if (name != null)
			sbf = new StringBuffer(name);
		else
			sbf = new StringBuffer(FIELD_SIZE);
		sbf.setLength(FIELD_SIZE);
		f.writeChars(sbf.toString());
	}

	private String readName(RandomAccessFile f) throws IOException {
		char name[] = new char[FIELD_SIZE];
		char temp;
		for (int i = 0; i < name.length; i++) {
			temp = f.readChar();
			name[i] = temp;
		}
		return new String(name).replace('\0', ' ');
	}

}
// to compile : javac -d . RandomEmpRecordObj.java