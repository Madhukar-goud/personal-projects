package com.madhukar;

public class Child extends Parent{
	
	public Child(){
	}
	
	public void doSomething(){
		super.doSomething();
		System.out.println("Child");
	}
}
