package edu.softserveinc.healthbody.webclient.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.CompetitionDTO;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.HealthBodyService;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.HealthBodyServiceImplService;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.UserCompetitionsDTO;
//import edu.softserveinc.healthbody.webclient.wrapperD.URLFormatter;
import edu.softserveinc.healthbody.webclient.utils.GoogleFitUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserCabinetController {

	public static final String BRONZE_MEDAL_ID = "44737314-5897-4103-9535-de5a99b5c657";
	public static final String SILVER_MEDAL_ID = "bcce892c-3fdd-499c-92ea-a22d1e1e4c22";
	public static final String GOLD_MEDAL_ID = "be0f0963-0111-46c9-872e-abf0ffc09167";

	/**
	 * @param model
	 * @param healthBody
	 * @return
	 */
	@RequestMapping(value = "/userCabinet.html", method = RequestMethod.GET)
	public String getUserList(Model model, @Autowired HealthBodyServiceImplService healthBody) {
		String userLogin = SecurityContextHolder.getContext().getAuthentication().getName();
		/* request.getUserPrincipal().getName(); */
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();

		/* Rest **/
		// URLFormatter formatter = new URLFormatter();
		// model.addAttribute("user", formatter.getUserByLogin("UserByLogin",
		// userLogin));
		/* Fit steps a day */
		String gettedAccessToken = GoogleFitUtils.postForAccessToken(service.getUserByLogin(userLogin).getGoogleApi());
		Long startTime = (System.currentTimeMillis() - 24 * 60 * 60 * 1000);
		String fitData = GoogleFitUtils.post(gettedAccessToken, startTime, System.currentTimeMillis());
		String stepCount = GoogleFitUtils.getStepCount(fitData);
		log.info(stepCount);

		List<CompetitionDTO> competitions = service.getAllCompetitionsByUser(1, Integer.MAX_VALUE, userLogin);
		int bronzeCount = 0;
		int silverCount = 0;
		int goldCount = 0;
		for (CompetitionDTO competition : competitions) {
			UserCompetitionsDTO userCompetition = service.getUserCompetition(competition.getIdCompetition(), userLogin);
			String award = userCompetition.getAwardsName();
			if (BRONZE_MEDAL_ID.equals(award))
				bronzeCount++;
			else if (SILVER_MEDAL_ID.equals(award))
				silverCount++;
			else if (GOLD_MEDAL_ID.equals(award))
				goldCount++;
		}
		log.info("bronze " + bronzeCount);
		log.info("silver " + silverCount);
		log.info("gold " + goldCount);

		/* SOAP **/
		model.addAttribute("bronze", bronzeCount);
		model.addAttribute("silver", silverCount);
		model.addAttribute("gold", goldCount);
		model.addAttribute("steps", stepCount);
		model.addAttribute("user", service.getUserByLogin(userLogin));
		model.addAttribute("usercompetitions", service.getAllCompetitionsByUser(1, Integer.MAX_VALUE, userLogin));
		return "userCabinet";
	}

}
