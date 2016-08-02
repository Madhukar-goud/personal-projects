package com.caveofprogramming.spring.dao;

public class Offer 
{
	private int id;
	private String name;
	private String email;
	private String offertext;
	
	public Offer(){
		System.out.println("Offer Object Created");
	}
	
	public Offer(String name, String email, String offertext){
		this.name = name;
		this.email = email;
		this.offertext = offertext;
	}
	
	public Offer(int id, String name, String email, String offertext){
		this.id = id;
		this.name = name;
		this.email = email;
		this.offertext = offertext;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOffertext() {
		return offertext;
	}
	public void setOffertext(String offertext) {
		this.offertext = offertext;
	}
	
	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email
				+ ", offertext=" + offertext + "]";
	}
	

}
