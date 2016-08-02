package com.assignments;

import java.io.BufferedReader;
import java.io.FileReader;

public class Assignment6 {
	
	public static void main(String[] args)
	{
		Assignment6 ass6 = new Assignment6();
		String diff = ass6.compareFiles("src/com/assignments/file1.txt","src/com/assignments/file2.txt");
		System.out.println("DIff is "+diff);
	}

	private String compareFiles(String file1, String file2) {
		StringBuilder diff = new StringBuilder();
		BufferedReader input1 = null;
		BufferedReader input2 = null;
		StringBuilder sFile1 = new StringBuilder();
		StringBuilder sFile2 = new StringBuilder();
		try{
			input1 = new BufferedReader(new FileReader(file1));
			input2 = new BufferedReader(new FileReader(file2));
			String line;
			while((line = input1.readLine()) != null)
			{
				if(line.trim().length() > 0)
				{
					sFile1.append(line.trim());
					sFile1.append(System.lineSeparator());
				}
			}
			while((line = input2.readLine()) != null)
			{
				if(line.trim().length() > 0)
				{
					sFile2.append(line.trim());
					sFile2.append(System.lineSeparator());
				}
			}
			System.out.println("File 1 is =>"+sFile1);
			System.out.println("File 2 is =>"+sFile2);
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try{
				if(input1 != null)
					input1.close();
				if(input2 != null)
					input2.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		diff.append(diffStrings(file1.toString(), file2.toString()));
		return diff.toString();
	}
	
	private String diffStrings(String s1, String s2)
	{
		String diff = "";
		if(s1.equals(s2)){
			return diff;
		}
		String[] sArray1 = s1.split(System.lineSeparator());
		String[] sArray2 = s2.split(System.lineSeparator());
		int lArray1 = sArray1.length;
		int lArray2 = sArray2.length;
		for(int i=0;i<lArray1;i++)
		{
			if(sArray1[i].equals(sArray2[i]))
			{
				
			}
		}
		return diff;
	}

}
