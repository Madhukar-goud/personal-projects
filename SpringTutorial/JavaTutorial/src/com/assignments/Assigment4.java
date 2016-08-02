package com.assignments;

public class Assigment4 {

	public static void main(String[] args) {

		Assigment4 as4 =new Assigment4();
		double emiAmt = as4.calculateEmi();
		System.out.println(emiAmt);
	}

	private double calculateEmi() {
		double principal = 100000;
		double roiPerAnnum = 10;
		double roiPerMonth = roiPerAnnum/1200;
		System.out.println(roiPerMonth);
		int tenureInMonths = 12;
		double emi = (principal * roiPerMonth * Math.pow((1+roiPerMonth), tenureInMonths))/(Math.pow((1+roiPerMonth), tenureInMonths) -1);
		return emi;
	}

}
