package com.madhukar.test.spring;

import java.util.List;

public class FruitBasket {

	private String name;
	private List<String> fruits;
	
	public FruitBasket(){}
	
	public FruitBasket(String name, List<String> fruits){
		this.name = name;
		this.fruits = fruits;
	}
	
	@Override
	public String toString(){
		StringBuilder sFruitBasket = new StringBuilder();
		sFruitBasket.append(name);
		for(String fruitName: fruits){
			sFruitBasket.append("-"+fruitName);
		}
		return sFruitBasket.toString();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getFruits() {
		return fruits;
	}
	public void setFruits(List<String> fruits) {
		this.fruits = fruits;
	}
	
	
}
