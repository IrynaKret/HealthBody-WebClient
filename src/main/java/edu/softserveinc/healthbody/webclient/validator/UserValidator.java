package edu.softserveinc.healthbody.webclient.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.softserveinc.healthbody.webclient.constants.ValidatorConstants;
import edu.softserveinc.healthbody.webclient.healthbody.webservice.UserDTO;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDTO userDTO = (UserDTO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.USER_NAME_FIELD,
				ValidatorConstants.USER_NAME_EMPTY_ERROR, ValidatorConstants.USER_NAME_EMPTY_MESSAGE);
		String userName = userDTO.getFirstname();
		int nameLength = userName.length();
		if ((nameLength < 2) || (nameLength > 20)) {
			errors.rejectValue(ValidatorConstants.USER_NAME_FIELD, ValidatorConstants.USER_NAME_TOOLONG_ERROR,
					ValidatorConstants.NAME_TOOLONG_MESSAGE);
		}
		if (!userName.matches(ValidatorConstants.USER_NAME_FORMAT)) {
			errors.rejectValue(ValidatorConstants.USER_NAME_FIELD, ValidatorConstants.USER_NAME_FORMAT_ERROR,
					ValidatorConstants.USER_NAME_FORMAT_MESSAGE);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.SURNAME_FIELD,
				ValidatorConstants.SURNAME_EMPTY_ERROR, ValidatorConstants.SURNAME_EMPTY_MESSAGE);
		String userLastname = userDTO.getLastname();
		int lastnameLength = userName.length();
		if ((lastnameLength < 2) || (lastnameLength > 20)) {
			errors.rejectValue(ValidatorConstants.SURNAME_FIELD, ValidatorConstants.SURNAME_TOOLONG_ERROR,
					ValidatorConstants.NAME_TOOLONG_MESSAGE);
		}
		if (!userLastname.matches(ValidatorConstants.USER_NAME_FORMAT)) {
			errors.rejectValue(ValidatorConstants.SURNAME_FIELD, ValidatorConstants.SURNAME_FORMAT_ERROR,
					ValidatorConstants.SURNAME_FORMAT_MESSAGE);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.AGE_FIELD,
				ValidatorConstants.AGE_EMPTY_ERROR, ValidatorConstants.AGE_EMPTY_MESSAGE);
		String age = userDTO.getAge();
		if (!age.matches(ValidatorConstants.AGE_FORMAT)) {
			errors.rejectValue(ValidatorConstants.AGE_FIELD, ValidatorConstants.AGE_FORMAT_ERROR,
					ValidatorConstants.AGE_FORMAT_MESSAGE);
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, ValidatorConstants.WEIGHT_FIELD,
				ValidatorConstants.WEIGHT_EMPTY_ERROR, ValidatorConstants.WEIGHT_EMPTY_MESSAGE);
		String weight = userDTO.getWeight();
		if (!weight.matches(ValidatorConstants.WEIGHT_FORMAT)) {
			errors.rejectValue(ValidatorConstants.WEIGHT_FIELD, ValidatorConstants.WEIGHT_FORMAT_ERROR,
					ValidatorConstants.WEIGHT_FORMAT_MESSAGE);
		}
	}
}
