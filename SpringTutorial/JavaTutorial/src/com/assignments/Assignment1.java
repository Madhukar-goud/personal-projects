package com.assignments;

import java.util.Scanner;

import com.sun.xml.internal.ws.util.StringUtils;


public class Assignment1 {
	
	public static void main(String[] args)
	{
		System.out.println("Enter number of rows");
		Scanner input = new Scanner(System.in);
		try{
			int numRows = Integer.parseInt(input.nextLine());
			StringBuffer sBuffer = new StringBuffer();
			for(int i = 0;i <= numRows;i++){
				sBuffer = new StringBuffer();
				for(int j=0;j<numRows-i;j++)
				{
					sBuffer.append(" ");
				}
				for(int k=0;k<=i;k++)
				{
					sBuffer.append("* ");
				}
				System.out.print(sBuffer.toString());
				System.out.println("");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			input.close();
		}
	}

}
