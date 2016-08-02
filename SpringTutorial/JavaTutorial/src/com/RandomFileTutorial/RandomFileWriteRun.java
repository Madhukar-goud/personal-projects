package com.RandomFileTutorial;

public class RandomFileWriteRun {
	public static void main(String args[]) {
		try {
			RandomFileWrite rf = new RandomFileWrite();
			rf.openFile();
			//rf.addRecords();
			rf.deleteRecords();
			rf.closeFile();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}