package com.lti.storefront.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StoreFrontController {

	@GetMapping("/")
	public String loadHome()
	{
		return "index";
	}
	
}
