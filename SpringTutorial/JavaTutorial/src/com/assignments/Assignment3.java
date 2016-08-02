package com.assignments;

public class Assignment3 {
	
	public static void main(String[] args)
	{
		int[] numArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		int sumPrime = getSumAtPrime(numArray);
		System.out.println("Sum at prime is: "+sumPrime);
	}

	private static int getSumAtPrime(int[] numArray) {
		int count = numArray.length;
		int totalSum =0;
		System.out.println(count);
		int iPrime = 0;
		for(int i=2;i<count;i++)
		{
			iPrime = 0;
			for(int j=2;j<=i/2;j++)
			{
				if(i%j == 0)
				{
				//	System.out.println(i+" is Not prime");
					iPrime++;
					break;
				}
			}
			if(iPrime == 0)
			{
				System.out.println(i+" is PRIME");
				totalSum+=numArray[i];
				
			}
		}
		return totalSum;
	}

}
