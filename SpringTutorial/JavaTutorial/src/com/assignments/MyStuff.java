package com.assignments;

interface Rideable {
	 String getGait();
}

public class MyStuff implements Rideable {
	int weight = 2;

	public static void main(String[] args) {
		new MyStuff().go(8);
	}

	void go(int speed) {
		++speed;
		weight++;
		int walkrate = speed * weight;
		System.out.print(walkrate + getGait());
	}

	public String getGait() {
		return " mph, lope";
	}
}