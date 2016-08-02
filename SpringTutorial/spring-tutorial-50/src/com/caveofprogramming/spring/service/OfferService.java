package com.caveofprogramming.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caveofprogramming.spring.dao.Offer;
import com.caveofprogramming.spring.dao.OfferDAO;

@Service("offerService")
public class OfferService {

	private OfferDAO offerDAO;
	
	@Autowired
	public void setOfferDAO(OfferDAO offerDAO) {
		this.offerDAO = offerDAO;
	}


	public List<Offer> getCurrentOffers(){
		return offerDAO.getOffers();
	}
}
