package com.cafe24.noahshop.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cafe24.noahshop.validator.constraints.ValidTel;

public class TelValidator implements ConstraintValidator<ValidTel, String> {

	private Pattern pattern = Pattern.compile("^[0-9]{3}[-]+[0-9]{4}[-]+[0-9]{4}$");
	
	@Override
	public void initialize(ValidTel constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.length() == 0 || "".equals(value)) {
			return false;
		}
		
		return pattern.matcher(value).matches();
	}

}
