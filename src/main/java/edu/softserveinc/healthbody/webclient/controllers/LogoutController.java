package edu.softserveinc.healthbody.webclient.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.softserveinc.healthbody.webclient.service.StatisticsService;

@Controller
public class LogoutController {
	
	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping(value = "/logout*")
	public String logoutSpringSecurity(Model model) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		SecurityContextHolder.clearContext();
		statisticsService.updateStatistics(new Date(), userLogin);	
		return "login";
	}
}
