package edu.softserveinc.healthbody.webclient.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.softserveinc.healthbody.webclient.dto.StatisticsDTO;
import edu.softserveinc.healthbody.webclient.service.StatisticsService;

@Controller
public class AddLoginStatisticsController {
	
	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping(value= "/addLoginStatistics.html")
	public String addLoginStatistics() {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		StatisticsDTO statisticsDTO = statisticsService.getUserForUpdate(userLogin);
		if (statisticsDTO != null) {
			Date logoutDate = new Date(statisticsDTO.getLoginDate().getTime() + 600000);
			statisticsService.updateStatistics(logoutDate, userLogin);
		}
		statisticsService.addStatistics(new StatisticsDTO(null, userLogin, new Date(), null));
		return "redirect:/main.html";	
	}
}
