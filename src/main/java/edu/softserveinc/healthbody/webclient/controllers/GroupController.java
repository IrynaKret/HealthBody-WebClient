package edu.softserveinc.healthbody.webclient.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.softserveinc.healthbody.webclient.api.HealthBodyService;
import edu.softserveinc.healthbody.webclient.api.HealthBodyServiceImplService;

@Controller
public class GroupController {
	private ApplicationContext context;

	@RequestMapping(value = "/group.html")
	public String getUserList(Model model, String name) {
		context = new AnnotationConfigApplicationContext(HealthBodyServiceImplService.class);
		HealthBodyServiceImplService healthBody = context.getBean(HealthBodyServiceImplService.class);
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		model.addAttribute("getGroup", service.getGroupByName(name));
		return "group";
	}
}