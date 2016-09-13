package edu.softserveinc.healthbody.webclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
			
	@RequestMapping("/homePage.html")
	public String homePage() {
		return "homePage";
	}
	
	@RequestMapping("/login.html")
	public String login() {
		return "login";
	}
}
