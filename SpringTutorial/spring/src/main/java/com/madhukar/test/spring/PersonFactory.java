package com.madhukar.test.spring;

public class PersonFactory {

	public Person createPerson(int id, String name)
	{
		return new Person(id, name);
	}
}
