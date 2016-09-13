package edu.softserveinc.healthbody.webclient.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.softserveinc.healthbody.webclient.dto.StatisticsDTO;
import edu.softserveinc.healthbody.webclient.service.StatisticsService;

@Controller
public class UserDurationOnAppController {
	
	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping(value = "/pieChart.html", method = RequestMethod.GET)
	public String showPieChart(Model model) {
		Map<String, Long> userDurationOnApp = new HashMap<>();
		List<String> loginList = statisticsService.getAllUsersLogin();
		for (String userLogin : loginList) {
			long durationOnApp = 0;
			for (StatisticsDTO userStatistics : statisticsService.getStatisticsByUserLogin(userLogin)) {
				if (userStatistics.getLogoutDate() != null) {
				durationOnApp += (userStatistics.getLogoutDate().getTime() - userStatistics.getLoginDate().getTime())/60000;
				}
			}
			userDurationOnApp.put(userLogin, durationOnApp);
		}
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("login", login);
		model.addAttribute("userDurationOnApp", userDurationOnApp);
		return "pieChart";
	}
}
