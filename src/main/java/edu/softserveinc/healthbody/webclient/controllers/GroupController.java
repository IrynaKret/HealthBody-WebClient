package edu.softserveinc.healthbody.webclient.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import edu.softserveinc.healthbody.webclient.healthbody.webservice.UserDTO;
import edu.softserveinc.healthbody.webclient.validator.GroupValidator;

@Controller
public class GroupController {

	@Autowired
	GroupValidator groupValidator;

	@RequestMapping(value = "/listGroups.html", method = RequestMethod.GET)
	public String getGroups(Model model, @Autowired HealthBodyServiceImplService healthBody,
			@RequestParam(value = "groupsParticipantsPartnumber", required = false) Integer groupsParticipantsPartnumber)
			throws IOException {

		/** Setting default quantity groups per page */
		final Integer DEFAULT_QUANTITY_GROUPS_PER_PAGE = 1;

		/**
		 * Avoid access to hole list of groups if in URL field will be inputed
		 * negative value -1 or lower (by hands)
		 */
		if (groupsParticipantsPartnumber == null || groupsParticipantsPartnumber <= 0)
			groupsParticipantsPartnumber = 1;

		/** Set current page */
		int currentPage = groupsParticipantsPartnumber;
		int startPartNumber = 1;

		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();

		/** Getting quantity of records in groups table in DB */
		int dataBaseRecordsQuontity = service.getAllGroupsParticipants(1, Integer.MAX_VALUE).size();

		/** Calculating last page number without remain */
		int lastpagePartNumber = (int) Math.ceil(dataBaseRecordsQuontity * 1.0 / DEFAULT_QUANTITY_GROUPS_PER_PAGE);

		/**
		 * Avoid access to the blank page if in URL will be inputed value more
		 * than last page number (by hands)
		 */
		if (groupsParticipantsPartnumber > lastpagePartNumber)
			groupsParticipantsPartnumber = lastpagePartNumber;

		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("startPartNumber", startPartNumber);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastpagePartNumber", lastpagePartNumber);

		/** SOAP */
		model.addAttribute("groups",
				service.getAllGroupsParticipants(groupsParticipantsPartnumber, DEFAULT_QUANTITY_GROUPS_PER_PAGE));

		// /** REST*/
		// URLFormatter formatter = new URLFormatter();
		// model.addAttribute("groups",
		// formatter.getGroupsByPartnumberPartsize("GroupsParticipants",
		// groupsParticipantsPartnumber, DEFAULT_QUANTITY_GROUPS_PER_PAGE));
		return "listGroups";
	}

	@RequestMapping(value = "/allGroups.html", method = RequestMethod.GET)
	public String allGroups(Model model, @Autowired HealthBodyServiceImplService healthBody,
			@RequestParam(value = "groupsPartnumber", required = false) Integer groupsPartnumber) {
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		/** Setting default quantity groups per page */
		final Integer DEFAULT_QUANTITY_GROUPS_PER_PAGE = 5;

		/**
		 * Avoid access to hole list of groups if in URL field will be inputed
		 * negative value -1 or lower (by hands)
		 */
		if (groupsPartnumber == null || groupsPartnumber <= 0)
			groupsPartnumber = 1;

		/** Set current page */
		int currentPage = groupsPartnumber;
		int startPartNumber = 1;
		/** Getting quantity of records in groups table in DB */
		int dataBaseRecordsQuontity = service.getAllGroups(1, Integer.MAX_VALUE).size();

		/** Calculating last page number without remain */
		int lastpagePartNumber = (int) Math.ceil(dataBaseRecordsQuontity * 1.0 / DEFAULT_QUANTITY_GROUPS_PER_PAGE);

		/**
		 * Avoid access to the blank page if in URL will be inputed value more
		 * than last page number (by hands)
		 */
		if (groupsPartnumber > lastpagePartNumber)
			groupsPartnumber = lastpagePartNumber;
		model.addAttribute("startPartNumber", startPartNumber);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastpagePartNumber", lastpagePartNumber);
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("groups", service.getAllGroups(groupsPartnumber, DEFAULT_QUANTITY_GROUPS_PER_PAGE));
		return "allGroups";
	}

	@RequestMapping(value = "/group.html", method = RequestMethod.GET)
	public String getGroup(Model model, @Autowired HealthBodyServiceImplService healthBody, String nameGroup) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		GroupDTO groupDTO = service.getGroupById(nameGroup);
		boolean test = false;
		for (GroupDTO group : service.getUserByLogin(userLogin).getGroups()) {
			if (group.getIdGroup().equals(nameGroup)) {
				test = true;
			}
		}
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("group", groupDTO);
		if (test) {
			return "leaveGroup";
		} else {
			return "joinGroup";
		}
	}

	@RequestMapping(value = "/joinGroup.html", method = RequestMethod.GET)
	public String joinGroup(Model model, @Autowired HealthBodyServiceImplService healthBody, String nameGroup) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		UserDTO user = service.getUserByLogin(userLogin);
		user.getGroups().add(service.getGroupById(nameGroup));
		service.updateUser(user);
		GroupDTO group = service.getGroupById(nameGroup);
		Integer userCount = Integer.parseInt(group.getCount()) + 1;
		group.setCount(userCount.toString());
		service.updateGroup(group);

		List<CompetitionDTO> competitions = service.getAllCompetitionsByGroup(1, Integer.MAX_VALUE, nameGroup);
		for (CompetitionDTO competitionDTO : competitions) {
			if (service.getUserCompetition(competitionDTO.getIdCompetition(), userLogin) == null) {
				service.addUserInCompetitionView(competitionDTO.getIdCompetition(), userLogin);
			}
		}
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("usercompetitions", service.getAllCompetitionsByUser(1, Integer.MAX_VALUE, userLogin));
		return "userCabinet";
	}

	@RequestMapping(value = "/leaveGroup.html", method = RequestMethod.GET)
	public String leaveGroup(Model model, @Autowired HealthBodyServiceImplService healthBody, String nameGroup) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		UserDTO user = service.getUserByLogin(userLogin);
		service.deleteUserFromGroup(user, nameGroup);
		GroupDTO group = service.getGroupById(nameGroup);
		Integer userCount = Integer.parseInt(group.getCount()) - 1;
		if (userCount <= 0) {
			userCount = 0;
		}
		group.setCount(userCount.toString());
		service.updateGroup(group);
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("usercompetitions", service.getAllCompetitionsByUser(1, Integer.MAX_VALUE, userLogin));
		return "userCabinet";
	}

	@RequestMapping(value = "/createGroup.html", method = RequestMethod.GET)
	public String createCompetitionDescription(Model model, @Autowired HealthBodyServiceImplService healthBody) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		GroupDTO groupDTO = new GroupDTO();
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("groupToCreate", groupDTO);
		return "createGroup";
	}

	@RequestMapping(value = "/createGroup.html", method = RequestMethod.POST)
	public String createCompetition(@ModelAttribute("groupToCreate") GroupDTO groupToCreate, Model model,
			BindingResult result) {
		HealthBodyServiceImplService healthBody = new HealthBodyServiceImplService();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		groupValidator.validateCreate(groupToCreate, result);
		if (result.hasErrors()) {
			return "createGroup";
		}
		GroupDTO groupDTO = groupToCreate;
		groupDTO.setIdGroup(UUID.randomUUID().toString());
		groupDTO.setName(groupToCreate.getName());
		groupDTO.setDescriptions(groupToCreate.getDescriptions());
		groupDTO.setStatus(groupToCreate.getStatus());
		groupDTO.setCount("0");
		groupDTO.setScoreGroup(groupToCreate.getScoreGroup());
		service.createGroup(groupDTO);
		return "redirect:/group.html?nameGroup=" + groupDTO.getIdGroup() + "&userLogin=" + userLogin;
	}

	@RequestMapping(value = "/editGroupDescription.html", method = RequestMethod.GET)
	public String editGroupDescription(Model model, @Autowired HealthBodyServiceImplService healthBody,
			String nameGroup) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		GroupDTO groupDTO = service.getGroupById(nameGroup);
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("group", groupDTO);
		return "editingGroup";
	}

	@RequestMapping(value = "editingGroup", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("group") GroupDTO groupEdit, Map<String, Object> model,
			BindingResult result) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyServiceImplService healthBody = new HealthBodyServiceImplService();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		groupValidator.validate(groupEdit, result);
		if (result.hasErrors()) {
			return "editingGroup";
		}
		GroupDTO groupDTO = groupEdit;
		groupDTO.setIdGroup(groupEdit.getIdGroup());
		groupDTO.setDescriptions(groupEdit.getDescriptions());
		groupDTO.setCount(groupEdit.getCount());
		groupDTO.setName(groupEdit.getName());
		groupDTO.setScoreGroup(groupEdit.getScoreGroup());
		groupDTO.setStatus(groupEdit.getStatus());

		service.updateGroup(groupDTO);
		model.put("user", service.getUserByLogin(userLogin));
		model.put("group", groupDTO);
		return "editGroupDescription";
	}
}
