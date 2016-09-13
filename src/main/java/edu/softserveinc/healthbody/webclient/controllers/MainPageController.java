package edu.softserveinc.healthbody.webclient.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.softserveinc.healthbody.webclient.healthbody.webservice.CompetitionDTO;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.HealthBodyService;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.HealthBodyServiceImplService;
import edu.softserveinc.healthbody.webclient.utils.FitData;
import lombok.extern.slf4j.Slf4j;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.OpenWeatherMap;
import net.aksingh.owmjapis.OpenWeatherMap.Units;

@Controller
@Slf4j
public class MainPageController {

	private final Integer COMPETITIONS_PER_PAGE = 10;

	@RequestMapping(value = "/main.html", method = RequestMethod.GET)
	public String getListCurrentCompetitions(Model model, @Autowired HealthBodyServiceImplService healthBody,
			@RequestParam(value = "partNumber", required = false) Integer partNumber, HttpServletRequest request) {
		try {
			HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
			int n = service.getAllActiveCompetitions(1, Integer.MAX_VALUE).size();
			int lastPartNumber = (int) Math.ceil(n * 1.0 / COMPETITIONS_PER_PAGE);
			if (partNumber == null || partNumber <= 0)
				partNumber = 1;
			if (partNumber > lastPartNumber)
				partNumber = lastPartNumber;
			int currentPage = partNumber;
			int startPartNumber = 1;
			String login = request.getUserPrincipal().getName();
			FitData.updateUsersScoresInCompetition(service, login);
			model.addAttribute("login", login);
			model.addAttribute("startPartNumber", startPartNumber);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("lastPartNumber", lastPartNumber);
			model.addAttribute("getAllComp", service.getAllActiveCompetitions(partNumber, COMPETITIONS_PER_PAGE));
			model.addAttribute("getAllCompTakePart",
					service.getAllActiveCompetitionsByUser(partNumber, COMPETITIONS_PER_PAGE, login));

			OpenWeatherMap weatherService = new OpenWeatherMap(Units.METRIC, "b117631346fcc98856c5dbfddf9a7245");
			CurrentWeather weather = null;

			JsonObject json = null;
			JsonParser parser = new JsonParser();
			String defaultCity = "Lviv";
			log.info("Get current weather for " + defaultCity + " in JSON format");
			weather = weatherService.currentWeatherByCityName(defaultCity);
			log.info("Parsing JSON");
			try {
				json = parser.parse(weather.getRawResponse()).getAsJsonObject();
				log.info(json.get("cod").getAsString());
				if (json.get("cod").getAsString().equals("200")) {
					weather = weatherService.currentWeatherByCityName(defaultCity);
					log.info("Parsing JSON");
					json = parser.parse(weather.getRawResponse()).getAsJsonObject();
					JsonObject main = json.getAsJsonObject("main");
					JsonArray weatherArray = json.getAsJsonArray("weather");
					JsonObject weatherElement = weatherArray.get(0).getAsJsonObject();
					JsonObject wind = json.getAsJsonObject("wind");
					model.addAttribute("city_name", json.get("name").getAsString());
					model.addAttribute("temp", main.get("temp").getAsString());
					model.addAttribute("humidity", main.get("humidity").getAsString());
					model.addAttribute("weather_icon", weatherElement.get("icon").getAsString());
					model.addAttribute("wind", wind.get("speed").getAsString());
					return "main";
				}
			} catch (Exception e) {
				log.error("Weather exception", e);
			}
		} catch (JSONException e) {
			log.error("JSONException", e);
		} catch (IOException e1) {
			log.error("IOException", e1);
		}
		return "main";
	}

	@RequestMapping(value = "/check_take_part.html", method = RequestMethod.GET)
	public String checkCompetition(Model model, @Autowired HealthBodyServiceImplService healthBody,
			String idCompetition) {
		String login = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		boolean test = false;
		for (CompetitionDTO competition : service.getAllActiveCompetitionsByUser(1, Integer.MAX_VALUE, login)) {
			if (competition.getIdCompetition().equals(idCompetition)) {
				test = true;
			}
		}
		model.addAttribute("user", service.getUserByLogin(login));
		model.addAttribute("getCompetition", service.getCompetitionViewById(idCompetition));
		if (test) {
			return "getOutOfCompetition";
		} else {
			return "joinCompetition";
		}
	}

	@RequestMapping(value = "/getOutOfCompetition.html", method = RequestMethod.GET)
	public String getOutCompetition(Model model, @Autowired HealthBodyServiceImplService healthBody,
			String idCompetition) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		service.removeUserFromCompetition(idCompetition, userLogin);
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("usercompetition", service.getAllCompetitionsByUser(1, Integer.MAX_VALUE, userLogin));
		return "redirect:main.html";

	}

}
