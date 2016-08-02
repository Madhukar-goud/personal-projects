package com.caveofprogramming.spring.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.caveofprogramming.spring.dao.Offer;
import com.caveofprogramming.spring.service.OfferService;

@Controller
public class OffersController {
	
	private OfferService offerService;
	
	@Autowired
	public void setOfferService(OfferService offerService) {
		this.offerService = offerService;
	}

	@RequestMapping("/offer")
	public String showOffers(Model model){
		List<Offer> offersList =offerService.getCurrentOffers();
		model.addAttribute("offers", offersList);
		return "offer";
	}
	
	@RequestMapping("createOffer")
	public String createOffers(){
		return "createOffer";
	}
}
