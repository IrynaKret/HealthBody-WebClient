package edu.softserveinc.healthbody.webclient.controllers;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.softserveinc.healthbody.webclient.healthbody.webservice.CompetitionDTO;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.GroupDTO;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.HealthBodyService;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.HealthBodyServiceImplService;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.UserCompetitionsDTO;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.UserDTO;
import edu.softserveinc.healthbody.webclient.utils.CustomDateFormater;
import edu.softserveinc.healthbody.webclient.utils.GoogleFitUtils;
import edu.softserveinc.healthbody.webclient.validator.CompetitionCreateValidator;
import edu.softserveinc.healthbody.webclient.validator.CompetitionEditValidator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CompetitionController {
	
	public static final String BRONZE_MEDAL_ID = "44737314-5897-4103-9535-de5a99b5c657";
	public static final String SILVER_MEDAL_ID = "bcce892c-3fdd-499c-92ea-a22d1e1e4c22";
	public static final String GOLD_MEDAL_ID = "be0f0963-0111-46c9-872e-abf0ffc09167";
	public static final String HEALTHY_WALKING_ID = "58f44c78-ccfa-4596-bcc3-7c1ba9908135";
	public static final String HEALTH_PEOPLE_ID = "533e416d-c3ef-44e3-9e22-cfc4feddf76d";

	@Autowired
	private CompetitionCreateValidator competitionCreateValidator;
	@Autowired
	private CompetitionEditValidator competitionEditValidator;

	final Integer COMPETITIONS_PER_PAGE = 5;
	final Integer GROUPS_PER_PAGE = 5;

	@RequestMapping(value = "/listCompetitions.html", method = RequestMethod.GET)
	public String getListCurrentCompetitions(Model model, @Autowired HealthBodyServiceImplService healthBody,
			@RequestParam(value = "partNumber", required = false) Integer partNumber, HttpServletRequest request) {

		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		int startPartNumber = 1;
		if (partNumber == null || partNumber <= 0)
			partNumber = 1;
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("startPartNumber", startPartNumber);
		
		UserCompetitionsDTO d = service.getUserCompetition("58f44c78-ccfa-4596-bcc3-7c1ba9908135", "volodya4u");
		log.info("volodya4u");
		log.info(d.getAwardsName() + " " + d.getTimeReceivedAward());
		UserCompetitionsDTO f = service.getUserCompetition("58f44c78-ccfa-4596-bcc3-7c1ba9908135", "vdzedzej");
		log.info("vdzedzej");
		log.info(f.getAwardsName() + " " + f.getTimeReceivedAward());
		UserCompetitionsDTO a = service.getUserCompetition("58f44c78-ccfa-4596-bcc3-7c1ba9908135", "rudyi.nazar");
		log.info("rudyi.nazar");
		log.info(a.getAwardsName() + " " + a.getTimeReceivedAward());
		UserCompetitionsDTO b = service.getUserCompetition("58f44c78-ccfa-4596-bcc3-7c1ba9908135", "fedorushunp");
		log.info("fedorushunp");
		log.info(b.getAwardsName() + " " + b.getTimeReceivedAward());

		if ("admin".equals(service.getUserByLogin(userLogin).getRoleName())) {
			int n = service.getAllCompetitions(1, Integer.MAX_VALUE).size();
			int lastPartNumber = (int) Math.ceil(n * 1.0 / COMPETITIONS_PER_PAGE);
			if (partNumber > lastPartNumber)
				partNumber = lastPartNumber;
			int currentPage = partNumber;
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("lastPartNumber", lastPartNumber);
			model.addAttribute("getCompetitions", service.getAllCompetitions(partNumber, COMPETITIONS_PER_PAGE));
			return "listCompetitionsAdmin";
		} else {
			int n = service.getAllActiveCompetitions(1, Integer.MAX_VALUE).size();
			int lastPartNumber = (int) Math.ceil(n * 1.0 / COMPETITIONS_PER_PAGE);
			if (partNumber > lastPartNumber)
				partNumber = lastPartNumber;
			int currentPage = partNumber;
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("lastPartNumber", lastPartNumber);
			model.addAttribute("getCompetitions", service.getAllActiveCompetitions(partNumber, COMPETITIONS_PER_PAGE));
			return "listCompetitions";
		}
	}

	@RequestMapping(value = "/competition.html", method = RequestMethod.GET)
	public String getCompetition(Model model, @Autowired HealthBodyServiceImplService healthBody,
			String idCompetition) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("getCompetition", service.getCompetitionViewById(idCompetition));
		model.addAttribute("getScore", service.getUserCompetition(idCompetition, userLogin));
		model.addAttribute("groupcompetitions", service.getAllGroupsByCompetition(1, Integer.MAX_VALUE, idCompetition));
		for (CompetitionDTO competition : service.getAllCompetitionsByUser(1, Integer.MAX_VALUE, userLogin)) {
			if (competition.getIdCompetition().equals(idCompetition)) {
				String gettedAccessToken = GoogleFitUtils
						.postForAccessToken(service.getUserByLogin(userLogin).getGoogleApi());
				Long startTime = CustomDateFormater
						.getDateInMilliseconds(service.getCompetitionViewById(idCompetition).getStartDate());
				String fitData = GoogleFitUtils.post(gettedAccessToken, startTime, System.currentTimeMillis());
				String stepCount = GoogleFitUtils.getStepCount(fitData);
				UserCompetitionsDTO userCompetition = service.getUserCompetition(idCompetition, userLogin);
				userCompetition.setUserScore(stepCount);
				service.updateUserCompetition(userCompetition);
				return "leaveCompetition";
			}
		}
		return "joinCompetition";
	}

	@RequestMapping(value = "/joinCompetition.html", method = RequestMethod.GET)
	public String joinCompetition(Model model, @Autowired HealthBodyServiceImplService healthBody,
			String idCompetition) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		service.addUserInCompetitionView(idCompetition, userLogin);
		String gettedAccessToken = GoogleFitUtils.postForAccessToken(service.getUserByLogin(userLogin).getGoogleApi());
		Long startTime = CustomDateFormater
				.getDateInMilliseconds(service.getCompetitionViewById(idCompetition).getStartDate());
		String fitData = GoogleFitUtils.post(gettedAccessToken, startTime, System.currentTimeMillis());
		String stepCount = GoogleFitUtils.getStepCount(fitData);
		UserCompetitionsDTO userCompetition = service.getUserCompetition(idCompetition, userLogin);
		userCompetition.setUserScore(stepCount);
		service.updateUserCompetition(userCompetition);
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("usercompetitions", service.getAllCompetitionsByUser(1, Integer.MAX_VALUE, userLogin));
		return "userCabinet";
	}

	@RequestMapping(value = "/leaveCompetition.html", method = RequestMethod.GET)
	public String leaveCompetition(Model model, @Autowired HealthBodyServiceImplService healthBody,
			String idCompetition) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		service.deleteUserCompetition(idCompetition, userLogin);
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("usercompetitions", service.getAllCompetitionsByUser(1, Integer.MAX_VALUE, userLogin));
		model.addAttribute("getScore", service.getUserCompetition(idCompetition, userLogin));
		return "userCabinet";
	}

	@RequestMapping(value = "/listOfGroups.html", method = RequestMethod.GET)
	public String getListCurrentGroups(Model model, @Autowired HealthBodyServiceImplService healthBody,
			String idCompetition, @RequestParam(value = "partNumber", required = false) Integer partNumber,
			HttpServletRequest request) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		int startPartNumber = 1;
		if (partNumber == null || partNumber <= 0)
			partNumber = 1;
		int n = service.getAllGroupsParticipants(1, Integer.MAX_VALUE).size();
		int lastPartNumber = (int) Math.ceil(n * 1.0 / GROUPS_PER_PAGE);
		if (partNumber > lastPartNumber)
			partNumber = lastPartNumber;
		int currentPage = partNumber;
		model.addAttribute("startPartNumber", startPartNumber);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPartNumber", lastPartNumber);
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("groups", service.getAllGroupsParticipants(partNumber, GROUPS_PER_PAGE));
		model.addAttribute("getCompetition", service.getCompetitionViewById(idCompetition));
		model.addAttribute("groupcompetitions", service.getAllGroupsByCompetition(1, Integer.MAX_VALUE, idCompetition));
		return "listOfGroups";
	}

	@RequestMapping(value = "/joinGroupCompetition.html", method = RequestMethod.GET)
	public String joinCompetition(Model model, @Autowired HealthBodyServiceImplService healthBody, String idCompetition,
			String idGroup) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		service.addGroupInCompetition(idCompetition, idGroup);

		List<GroupDTO> listgroups = service.getAllGroupsParticipants(1, Integer.MAX_VALUE);
		for (GroupDTO group : listgroups) {
			if (group.getIdGroup().equals(idGroup)) {
				for (String login : group.getUsers()) {
					if (service.getUserCompetition(idCompetition, login) == null) {
						service.addUserInCompetitionView(idCompetition, login);
					}
				}
			}
		}
		model.addAttribute("idCompetition", idCompetition);
		model.addAttribute("userLogin", userLogin);
		model.addAttribute("groupcompetitions", service.getAllGroupsByCompetition(1, Integer.MAX_VALUE, idCompetition));
		return "redirect:/competition.html?idCompetition={idCompetition}&userLogin={userLogin}";
	}

	@RequestMapping(value = "/leaveGroupCompetition.html", method = RequestMethod.GET)
	public String leaveCompetition(Model model, @Autowired HealthBodyServiceImplService healthBody,
			String idCompetition, String idGroup) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		service.deleteGroupCompetition(idCompetition, idGroup);
		model.addAttribute("idCompetition", idCompetition);
		model.addAttribute("userLogin", userLogin);
		model.addAttribute("groupcompetitions", service.getAllGroupsByCompetition(1, Integer.MAX_VALUE, idCompetition));
		return "redirect:/competition.html?idCompetition={idCompetition}&userLogin={userLogin}";
	}

	@RequestMapping(value = "/createCompetition.html", method = RequestMethod.GET)
	public String createCompetitionDescription(Model model, @Autowired HealthBodyServiceImplService healthBody) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		CompetitionDTO competitionDTO = new CompetitionDTO();
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("competitionToCreate", competitionDTO);
		return "createCompetition";
	}

	@RequestMapping(value = "/createCompetition.html", method = RequestMethod.POST)
	public String createCompetition(@ModelAttribute("competitionToCreate") CompetitionDTO competitionToCreate,
			Model model, BindingResult result) {
		competitionCreateValidator.validate(competitionToCreate, result);
		HealthBodyServiceImplService healthBody = new HealthBodyServiceImplService();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("user", service.getUserByLogin(userLogin));
		if (result.hasErrors()) {
			return "createCompetition";
		}
		CompetitionDTO competitionDTO = competitionToCreate;
		competitionDTO.setIdCompetition(UUID.randomUUID().toString());
		competitionDTO.setName(competitionToCreate.getName());
		competitionDTO.setDescription(competitionToCreate.getDescription());
		competitionDTO.setStartDate(competitionToCreate.getStartDate());
		competitionDTO.setFinishDate(competitionToCreate.getFinishDate());
		service.createCompetition(competitionDTO);
		return "redirect:/listCompetitions.html";
	}

	@RequestMapping(value = "/editCompetition.html", method = RequestMethod.GET)
	public String editCompetitionDescription(Model model, @Autowired HealthBodyServiceImplService healthBody,
			String idCompetition) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		CompetitionDTO competitionDTO = service.getCompetitionViewById(idCompetition);
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("competitionToEdit", competitionDTO);
		return "editCompetition";
	}

	@RequestMapping(value = "/editCompetition.html", method = RequestMethod.POST)
	public String editCompetition(@ModelAttribute("competitionToEdit") CompetitionDTO competitionToEdit, Model model,
			BindingResult result) {
		competitionEditValidator.validate(competitionToEdit, result);
		HealthBodyServiceImplService healthBody = new HealthBodyServiceImplService();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("user", service.getUserByLogin(userLogin));
		if (result.hasErrors()) {
			return "editCompetition";
		}
		CompetitionDTO competitionDTO = service.getCompetitionViewById(competitionToEdit.getIdCompetition());
		competitionDTO.setName(competitionToEdit.getName());
		competitionDTO.setDescription(competitionToEdit.getDescription());
		competitionDTO.setStartDate(competitionToEdit.getStartDate());
		competitionDTO.setFinishDate(competitionToEdit.getFinishDate());
		service.updateCompetition(competitionDTO);
		return "redirect:/listCompetitions.html";
	}
	
	@RequestMapping(value = "/recountAwards.html", method = RequestMethod.GET)
	public String recountSteps(Model model, @Autowired HealthBodyServiceImplService healthBody) {
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		
		List<GroupDTO> listgroups = service.getAllGroupsParticipants(1, Integer.MAX_VALUE);
		for (GroupDTO groupdto : listgroups) {
			log.info(groupdto.getName());
			Integer usersInGroup = groupdto.getUsers().size();
			List<CompetitionDTO> listcompetitions = service.getAllCompetitionsByGroup(1, Integer.MAX_VALUE,
					groupdto.getIdGroup());
			if (listcompetitions.isEmpty())
				continue;
			for (CompetitionDTO competitionDTO : listcompetitions) {
				Integer userScore = 0;
				log.info(competitionDTO.getName());
				DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
				DateTime start = formatter.parseDateTime(competitionDTO.getStartDate());
				DateTime today = DateTime.now().withTimeAtStartOfDay();
				Integer days = Days.daysBetween(start, today).getDays();
				log.info("Days per competition " + days);
				for (String login : groupdto.getUsers()) {
					log.info(login);
					UserCompetitionsDTO usercompetition = service.getUserCompetition(competitionDTO.getIdCompetition(),
							login);
					if (usercompetition == null)
						continue;
					userScore = userScore + Integer.parseInt(usercompetition.getUserScore());
					log.info("User score " + userScore);
				}
				Integer averageScore = userScore / usersInGroup / days;
				log.info("Average score " + averageScore);

				Date date = new Date(System.currentTimeMillis());
				if (averageScore >= 5000 && averageScore < 7000) {
					log.info(date.toString());
					for (String login : groupdto.getUsers()) {
						UserCompetitionsDTO usercompetition = service
								.getUserCompetition(competitionDTO.getIdCompetition(), login);
						if (usercompetition == null)
							continue;
						usercompetition.setAwardsName(BRONZE_MEDAL_ID);
						usercompetition.setTimeReceivedAward(date.toString());
						service.updateUserCompetition(usercompetition);
					}
				} else if (averageScore >= 7000 && averageScore < 9000) {
					log.info(date.toString());
					for (String login : groupdto.getUsers()) {
						UserCompetitionsDTO usercompetition = service
								.getUserCompetition(competitionDTO.getIdCompetition(), login);
						if (usercompetition == null)
							continue;
						usercompetition.setAwardsName(SILVER_MEDAL_ID);
						usercompetition.setTimeReceivedAward(date.toString());
						service.updateUserCompetition(usercompetition);
					}
				} else if (averageScore >= 9000) {
					log.info(date.toString());
					for (String login : groupdto.getUsers()) {
						UserCompetitionsDTO usercompetition = service
								.getUserCompetition(competitionDTO.getIdCompetition(), login);
						if (usercompetition == null)
							continue;
						usercompetition.setAwardsName(GOLD_MEDAL_ID);
						usercompetition.setTimeReceivedAward(date.toString());
						service.updateUserCompetition(usercompetition);
					}
				}
			}
		}
		return "redirect:/listCompetitions.html";
	}
	
	@RequestMapping(value = "/removeInactiveUsers.html", method = RequestMethod.GET)
	public String removeInactiveUsers(Model model, @Autowired HealthBodyServiceImplService healthBody) {
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		List<GroupDTO> groups = service.getAllGroupsParticipants(1, Integer.MAX_VALUE);
		for (GroupDTO groupDTO : groups) {
			if (HEALTH_PEOPLE_ID.equals(groupDTO.getIdGroup())) {
				for (String login : groupDTO.getUsers()) {
					String userScore = service.getUserCompetition(HEALTHY_WALKING_ID, login).getUserScore();
					Integer score = Integer.parseInt(userScore);
					if (score < 100) {
						//leave group
						UserDTO user = service.getUserByLogin(login);
						service.deleteUserFromGroup(user, HEALTH_PEOPLE_ID);
						GroupDTO group = service.getGroupById(HEALTH_PEOPLE_ID);
						Integer userCount = Integer.parseInt(group.getCount()) - 1;
						if (userCount <= 0) {
							userCount = 0;
						}
						group.setCount(userCount.toString());
						service.updateGroup(group);
						//leave competition
						service.deleteUserCompetition(HEALTHY_WALKING_ID, login);
					}
				}
			}
		}
		return "redirect:/listCompetitions.html";
	}
}