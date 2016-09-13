package edu.softserveinc.healthbody.webclient.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.softserveinc.healthbody.webclient.constants.ValidatorConstants;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.GroupDTO;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.HealthBodyService;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.HealthBodyServiceImplService;

@Component
public class GroupValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return GroupDTO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		GroupDTO groupDTO = (GroupDTO) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.NAME_FIELD,
				ValidatorConstants.NAME_EMPTY_ERROR, ValidatorConstants.GROUP_NAME_EMPTY_MESSAGE);

		String groupName = groupDTO.getName();
		int groupLength = groupName.length();
		if ((groupLength < 2) || (groupLength > 20)) {
			errors.rejectValue(ValidatorConstants.NAME_FIELD, ValidatorConstants.NAME_TOOLONG_ERROR,
					ValidatorConstants.NAME_TOOLONG_MESSAGE);
		}
		if (!groupName.matches(ValidatorConstants.NAME_FORMAT)) {
			errors.rejectValue(ValidatorConstants.NAME_FIELD, ValidatorConstants.NAME_FORMAT_ERROR,
					ValidatorConstants.NAME_FORMAT_MESSAGE);
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.DESCRIPTIONS_FIELD,
				ValidatorConstants.DESCRIPTION_EMPTY_ERROR, ValidatorConstants.GROUP_DESCRIPTION_EMPTY_MESSAGE);

		String descriptionName = groupDTO.getDescriptions();
		int descriptionLength = descriptionName.length();
		if ((descriptionLength < 4) || (descriptionLength > 100)) {
			errors.rejectValue(ValidatorConstants.DESCRIPTIONS_FIELD, ValidatorConstants.DESCRIPTION_TOOLONG_ERROR,
					ValidatorConstants.DESCRIPTION_TOOLONG_MESSAGE);
		}
		if (!descriptionName.matches(ValidatorConstants.DESCRIPTION_FORMAT)) {
			errors.rejectValue(ValidatorConstants.DESCRIPTIONS_FIELD, ValidatorConstants.DESCRIPTION_FORMAT_ERROR,
					ValidatorConstants.DESCRIPTION_FORMAT_MESSAGE);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.GROUP_STATUS,
				ValidatorConstants.GROUP_STATUS_EMPTY_ERROR, ValidatorConstants.GROUP_STATUS_TOOLONG_MESSAGE);

		String status = groupDTO.getStatus();
		if (!("active".equals(status)) || ("disabled".equals(status))) {
			errors.rejectValue(ValidatorConstants.GROUP_STATUS, ValidatorConstants.GROUP_STATUS_EMPTY_ERROR,
					ValidatorConstants.GROUP_STATUS_TOOLONG_MESSAGE);
		}
	}

	public void validateCreate(Object target, Errors errors) {

		HealthBodyServiceImplService healthBody = new HealthBodyServiceImplService();
		HealthBodyService service = healthBody.getHealthBodyServiceImplPort();
		GroupDTO groupDTO = (GroupDTO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.NAME_FIELD,
				ValidatorConstants.NAME_EMPTY_ERROR, ValidatorConstants.GROUP_NAME_EMPTY_MESSAGE);

		String groupName = groupDTO.getName();
		int groupLength = groupName.length();
		if ((groupLength < 2) || (groupLength > 20)) {
			errors.rejectValue(ValidatorConstants.NAME_FIELD, ValidatorConstants.NAME_TOOLONG_ERROR,
					ValidatorConstants.NAME_TOOLONG_MESSAGE);
		}
		if (!groupName.matches(ValidatorConstants.NAME_FORMAT)) {
			errors.rejectValue(ValidatorConstants.NAME_FIELD, ValidatorConstants.NAME_FORMAT_ERROR,
					ValidatorConstants.NAME_FORMAT_MESSAGE);
		}
		if (!groupDTO.getName().isEmpty()) {
			if (service.getGroupByName(groupName) != null) {
				errors.rejectValue(ValidatorConstants.NAME_FIELD, ValidatorConstants.NAME_EXIST_ERROR,
						ValidatorConstants.NAME_EXIST_MESSAGE);
			}
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.DESCRIPTIONS_FIELD,
				ValidatorConstants.DESCRIPTION_EMPTY_ERROR, ValidatorConstants.GROUP_DESCRIPTION_EMPTY_MESSAGE);

		String descriptionName = groupDTO.getDescriptions();
		int descriptionLength = descriptionName.length();
		if ((descriptionLength < 4) || (descriptionLength > 100)) {
			errors.rejectValue(ValidatorConstants.DESCRIPTIONS_FIELD, ValidatorConstants.DESCRIPTION_TOOLONG_ERROR,
					ValidatorConstants.DESCRIPTION_TOOLONG_MESSAGE);
		}
		if (!descriptionName.matches(ValidatorConstants.DESCRIPTION_FORMAT)) {
			errors.rejectValue(ValidatorConstants.DESCRIPTIONS_FIELD, ValidatorConstants.DESCRIPTION_FORMAT_ERROR,
					ValidatorConstants.DESCRIPTION_FORMAT_MESSAGE);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.GROUP_STATUS,
				ValidatorConstants.GROUP_STATUS_EMPTY_ERROR, ValidatorConstants.GROUP_STATUS_EMPTY_MESSAGE);

		String status = groupDTO.getStatus();
		if (!("active".equals(status)) || ("disabled".equals(status))) {
			errors.rejectValue(ValidatorConstants.GROUP_STATUS, ValidatorConstants.GROUP_STATUS_EMPTY_ERROR,
					ValidatorConstants.GROUP_STATUS_TOOLONG_MESSAGE);
		}
	}
}