package com.madhukar.test.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private String user;
	private String password;
	
    public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main( String[] args )
    {
    	ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
    	/*Person p = (Person)context.getBean("person");
    	Person p2 = (Person)context.getBean("person2");
    	System.out.println(p);
    	System.out.println(p2);
    	Address address2 = (Address)context.getBean("address2");
    	System.out.println(address2);
    	FruitBasket fruitBasket = (FruitBasket)context.getBean("fruitBasket");
    	System.out.println(fruitBasket);
    	App appNew = (App)context.getBean("app");
    	System.out.println("Printing User: ==>"+appNew.getUser()+" Printing Password"+appNew.getPassword());*/
    	OfferDAO offerDAO = (OfferDAO)context.getBean("offerDAO");
    	List<Offer> offers = offerDAO.getOffers();
    	for(Offer offer: offers)
    	{
    		System.out.println(offer);
    	}
    	Offer offer = offerDAO.getOffer(2);
    	System.out.println(offer);
    	
    	List<Offer> listNewOffers = new ArrayList<Offer>();
    	listNewOffers.add(new Offer(111, "Dave3", "Cave3@gmail.com", "Offer 10"));
    	listNewOffers.add(new Offer(1, "Dave", "Cave@gmail.com", "Offer 8"));
    	listNewOffers.add(new Offer(2, "Dave2", "Cave2@gmail.com", "Offer 9"));
    	System.out.println(offerDAO.create(listNewOffers));
    	((FileSystemXmlApplicationContext)context).close();
    }
}
