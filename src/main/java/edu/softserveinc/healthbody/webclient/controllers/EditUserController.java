package edu.softserveinc.healthbody.webclient.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.softserveinc.healthbody.webclient.healthbody.webservice.HealthBodyService;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.HealthBodyServiceImplService;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.UserDTO;
import edu.softserveinc.healthbody.webclient.validator.UserValidator;
//import edu.softserveinc.healthbody.webclient.wrapperD.URLFormatter;
//import edu.softserveinc.healthbody.webclient.wrapperD.UserDTORest;

@Controller
@RequestMapping(value = "/editUser.html")
public class EditUserController {
	
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getUserForEdit(Map<String, Object> model, @Autowired HealthBodyServiceImplService healthBody) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		UserDTO userToEdit = service.getUserByLogin(userLogin);
		model.put("user", userToEdit);
		return "editUser";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("user") UserDTO userToEdit, Map<String, Object> model, 
			BindingResult result) {
		HealthBodyServiceImplService healthBody = new HealthBodyServiceImplService();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		userToEdit.setLogin(userLogin);
		userValidator.validate(userToEdit, result);
		if (result.hasErrors()) {
			return "editUser";
		}
		UserDTO user = service.getUserByLogin(userLogin);
		user.setFirstname(userToEdit.getFirstname());
		user.setLastname(userToEdit.getLastname());
		user.setAge(userToEdit.getAge());
		user.setWeight(userToEdit.getWeight());
		user.setGender(userToEdit.getGender());
		user.setHealth(userToEdit.getHealth());
		service.updateUser(user);

//		Rest
//		URLFormatter formatter = new URLFormatter();
//		UserDTORest user = formatter.getUserByLogin("UserByLogin", userLogin);
//		user.setFirstname(userToEdit.getFirstname());
//		user.setLastname(userToEdit.getLastname());
//		user.setAge(userToEdit.getAge());
//		user.setWeight(userToEdit.getWeight());
//		user.setGender(userToEdit.getGender());
//		user.setHealth(userToEdit.getHealth());
//		URLFormatter formatterForUserUpdate = new URLFormatter();
//		formatterForUserUpdate.updateUser(user);
//		model.put("user", formatter.getUserByLogin("UserByLogin", userLogin));
		
		return "redirect:/userCabinet.html";
	}

}
