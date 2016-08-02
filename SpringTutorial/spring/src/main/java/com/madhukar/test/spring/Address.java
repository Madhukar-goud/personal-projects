package com.madhukar.test.spring;

public class Address {
	private String street;
	private String postcode;
	
	public Address(){}
	
	public Address(String street, String postcode)
	{
		this.street = street;
		this.postcode = postcode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public void init(){
		System.out.println("in init of Address");
	}
	
	public void destroy()
	{
		System.out.println("In destroy of Address");
	}
	
	public String toString()
	{
		return "Address: Street==>"+this.street +" : PostCode ==>"+this.postcode;
	}
}
