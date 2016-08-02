package com.assignments;

public class Gamma implements Runnable{

	public static void main(String[] args) {
		Gamma g1 = new Gamma();
		Thread t1 = new Thread(g1);
		t1.start();
		t1.start();
	}

	@Override
	public void run() {
		System.out.println("Main");
	}
}