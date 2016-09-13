package edu.softserveinc.healthbody.webclient.validator;

import java.sql.Date;

import org.apache.commons.validator.routines.DateValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.softserveinc.healthbody.webclient.constants.ValidatorConstants;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.CompetitionDTO;

@Component
public class CompetitionEditValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return CompetitionDTO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		CompetitionDTO competitionDTO = (CompetitionDTO) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.NAME_FIELD,
				ValidatorConstants.NAME_EMPTY_ERROR, ValidatorConstants.NAME_EMPTY_MESSAGE);

		String competitionName = competitionDTO.getName();
		int competitionLength = competitionName.length();
		if ((competitionLength < 2) || (competitionLength > 20)) {
			errors.rejectValue(ValidatorConstants.NAME_FIELD, ValidatorConstants.NAME_TOOLONG_ERROR,
					ValidatorConstants.NAME_TOOLONG_MESSAGE);
		}
		if (!competitionName.matches(ValidatorConstants.NAME_FORMAT)) {
			errors.rejectValue(ValidatorConstants.NAME_FIELD, ValidatorConstants.NAME_FORMAT_ERROR,
					ValidatorConstants.NAME_FORMAT_MESSAGE);
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.DESCRIPTION_FIELD,
				ValidatorConstants.DESCRIPTION_EMPTY_ERROR, ValidatorConstants.DESCRIPTION_EMPTY_MESSAGE);

		String descriptionName = competitionDTO.getDescription();
		int descriptionLength = descriptionName.length();
		if ((descriptionLength < 4) || (descriptionLength > 100)) {
			errors.rejectValue(ValidatorConstants.DESCRIPTION_FIELD, ValidatorConstants.DESCRIPTION_TOOLONG_ERROR,
					ValidatorConstants.DESCRIPTION_TOOLONG_MESSAGE);
		}
		if (!descriptionName.matches(ValidatorConstants.DESCRIPTION_FORMAT)) {
			errors.rejectValue(ValidatorConstants.DESCRIPTION_FIELD, ValidatorConstants.DESCRIPTION_FORMAT_ERROR,
					ValidatorConstants.DESCRIPTION_FORMAT_MESSAGE);
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.STARTDATE_FIELD,
				ValidatorConstants.STARTDATE_EMPTY_ERROR, ValidatorConstants.STARTDATE_EMPTY_MESSAGE);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.FINISHDATE_FIELD,
				ValidatorConstants.FINISHDATE_EMPTY_ERROR, ValidatorConstants.FINISHDATE_EMPTY_MESSAGE);

		String startDate = competitionDTO.getStartDate();
		String finishDate = competitionDTO.getFinishDate();
		DateValidator validator = DateValidator.getInstance();
		if (!validator.isValid(startDate, ValidatorConstants.DATE_FORMAT)) {
			errors.rejectValue(ValidatorConstants.STARTDATE_FIELD, ValidatorConstants.STARTDATE_FORMAT_ERROR,
					ValidatorConstants.DATE_FORMAT_MESSAGE);
		}
		if (!validator.isValid(finishDate, ValidatorConstants.DATE_FORMAT)) {
			errors.rejectValue(ValidatorConstants.FINISHDATE_FIELD, ValidatorConstants.FINISHDATE_FORMAT_ERROR,
					ValidatorConstants.DATE_FORMAT_MESSAGE);
		}

		if (startDate != "" && finishDate != "" && validator.isValid(startDate, ValidatorConstants.DATE_FORMAT)
				&& validator.isValid(finishDate, ValidatorConstants.DATE_FORMAT)) {
			Date start = Date.valueOf(startDate);
			Date finish = Date.valueOf(finishDate);
			if (start.after(finish)) {
				errors.rejectValue(ValidatorConstants.STARTDATE_FIELD, ValidatorConstants.STARTDATE_INCORRECT_ERROR,
						ValidatorConstants.STARTDATE_INCORRECT_MESSAGE);
			}
		}

	}
}