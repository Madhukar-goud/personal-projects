package com.RandomFileTutorial;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;
import java.io.EOFException;

public class RandomFileWrite {
	private RandomAccessFile output;
	private RandomAccessFile input;
	private static final int REC_NO = 100;
	// idStore;

	public void openFile() throws IOException, Exception {
		try {
			output = new RandomAccessFile("clients.dat", "rw");
			input = new RandomAccessFile("clients.dat", "r");
			// loadStore();
		} catch (IOException e) {
			System.out.println("Error opening file..");
			throw e;
		}

	}

	public void closeFile() throws IOException {
		try {
			if (output != null)
				output.close();
			if (input != null)
				input.close();
		} catch (IOException e) {
			System.out.println("Error closing file..");
			throw e;
		}

	}

	public void addRecords() throws Exception {
		RandomEmpRecordObj re = new RandomEmpRecordObj();
		String id;
		String fName;
		String lName;
		int age = 0;
		int tel = 0;
		int rowNo = 0;

		Scanner scan = new Scanner(System.in);
		System.out.printf("%s\n%s","Enter <Id> <first-name> <last-name> <age> <tel-no> <ROW_NO> <ctrl+z to terminate>",	"? ");

		while (scan.hasNext()) {
			try {
				id = scan.next();
				fName = scan.next();
				lName = scan.next();
				age = scan.nextInt();
				tel = scan.nextInt();
				rowNo = scan.nextInt() - 1;
				re.setId(id);
				re.setFname(fName);
				re.setLname(lName);
				re.setAge(age);
				re.setTel(tel);
				output.seek(rowNo * RandomEmpRecordObj.SIZE);
				rowNo++;

				re.write(output);
			} catch (Exception e) {
				System.out.println("Error while adding records.");
				throw e;
			}
			System.out
					.printf("%s\n%s",
							"Enter <Id> <first-name> <last-name> <age> <tel-no> <ROW_NO> <ctrl+z to terminate>",
							"? ");
		}
	}

	public void deleteRecords() {
		RandomEmpRecordObj re = new RandomEmpRecordObj();
		Scanner scan = new Scanner(System.in);
		System.out.printf("Give the emp id of record you want to delete <ctrl+z to terminate>");
		try {
			HashMap<String, String> hashRead = readRecords();
			System.out.println(hashRead);
			while (scan.hasNext()) {
				try {
					String id = scan.nextLine();
					int rowNo = Integer.parseInt(hashRead.get(id))-2;
					System.out.println(rowNo);
					output.seek(rowNo * RandomEmpRecordObj.SIZE);
					re.write(output);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.printf("Give the next emp id of record you want to delete <ctrl+z to terminate>");
			}
		} catch (Exception e) {
			System.out.printf("Exception in readRecords call from delete");
		}

	}

	public HashMap<String, String> readRecords() throws Exception { // private loadStore()
		int rowNo = 1;
		RandomEmpRecordObj eRec = new RandomEmpRecordObj();
		System.out.printf("%-6s%-15s%-15s%-15s%-10s%-10s\n", "Row No", "ID",
				"Fname", "Lname", "Age", "Tel");
		HashMap<String, String> hashMap = new HashMap<>();
		try {
			while (true) {
				eRec.read(input);
				System.out.printf("%-6d%-15s%-15s%-15s%-10d%-10d\n", rowNo++,eRec.getId(), eRec.getFname(), eRec.getLname(), eRec.getAge(),	eRec.getTel());
				hashMap.put(eRec.getId().trim(), rowNo+"".trim());
			}
		} catch (EOFException eof) {
			System.out.println("End of file");
			return hashMap;
		} catch (Exception e) {
			closeFile();
			e.printStackTrace();
			System.out.println("Error while reading records.");
			throw e;
		}
	}

}
