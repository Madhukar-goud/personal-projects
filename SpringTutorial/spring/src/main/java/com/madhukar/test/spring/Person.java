package com.madhukar.test.spring;

public class Person {
	private int id;
	private String name;
	private int taxId;
	
	private Address address;
	
	public static Person getInstance(int id, String name)
	{
		return new Person(id, name);
	}
	
	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public int getTaxId() {
		return taxId;
	}


	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;	
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public Person(int id, String name)
	{
		this.id = id;
		this.name = name;
	}


	public void speak()
	{
		System.out.println("I'm a person speaking with id ==>"+id+" Name==>"+name+" : TaxId==>"+taxId);

	}
	
	public String toString()
	{
		return "I'm a person speaking with id ==>"+id+" Name==>"+name+" : TaxId==>"+taxId+" : Address==> "+address;
	}
	
	public void onCreate()
	{
		System.out.println("In onCreate Method");
	}
	
	public void onDestroy()
	{
		System.out.println("In onDestroy Method");
	}
}
