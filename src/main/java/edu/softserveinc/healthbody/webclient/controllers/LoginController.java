package edu.softserveinc.healthbody.webclient.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping(value= "/login*")
	public String loginSpringSecurity(Model model) {
		return "login";
	}
}
