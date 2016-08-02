package com.madhukar;

import java.io.File;
import java.util.ArrayList;

public class GenericsExample {
	
	private ArrayList<String> stringCollection ;
	private MyGenericClass<String> myGenericClass;
	private Box<StringBuilder> boxOfChoclates = new Box<>();
	
	public void callMe(){
		stringCollection = new ArrayList<>();
		stringCollection.add("Madhukar");
		stringCollection.add("UmaShankar");
		
		ArrayList<String> stringCollection2 = new ArrayList<>();
		stringCollection2 = (ArrayList<String>)stringCollection.clone();
		System.out.println(stringCollection2);
		stringCollection.add("Madz");
		System.out.println(stringCollection2);
		myGenericClass = new MyGenericClass<String>("Madhukar", "Uma");
		boxOfChoclates.set(new StringBuilder("asdasd"));
		System.out.println(boxOfChoclates.get());
		System.out.println(myGenericClass.getFirst());
		System.out.println(myGenericClass.getSecond());
	}

	public static void main(String[] args) {
		GenericsExample genExample = new GenericsExample();
//		genExample.callMe();
		String sName = "Madhukar";
		System.out.println(""+sName.replace('\0', ' '));
		
	}

}
