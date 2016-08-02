package com.assignments;

import java.util.Scanner;
import java.util.StringTokenizer;

import com.sun.xml.internal.ws.util.StringUtils;

public class Assignment2 {
	
	public static void main(String[] args)
	{
		Assignment2 assign2 = new Assignment2();
		System.out.println("Enter IP Address");
		String enteredIpAddress = new Scanner(System.in).nextLine();
		System.out.println(enteredIpAddress);
		boolean validate = assign2.validateIp(enteredIpAddress);
		System.out.println(validate);
	}

	private boolean validateIp(String ipAddress) {
		StringTokenizer sTokens = new StringTokenizer(ipAddress, ".");
		System.out.println(sTokens.countTokens());
		if(sTokens.countTokens() != 4)
		{
			return false;
		}
		int ip;
		while(sTokens.hasMoreTokens())
		{
			ip = Integer.parseInt(sTokens.nextToken());
			System.out.println(ip);
			if(ip > 255 | ip <0)
			{
				System.out.println("False");
				return false;
			}
		}
		return true;
	}

}
