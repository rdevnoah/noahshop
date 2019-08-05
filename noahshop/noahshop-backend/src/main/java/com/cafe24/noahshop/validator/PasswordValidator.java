package com.cafe24.noahshop.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cafe24.noahshop.validator.constraints.ValidPassword;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

	private Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@!*#?])[A-Za-z\\d@!*#?]{8,}$");
	
	@Override
	public void initialize(ValidPassword constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || value.length() == 0 || "".equals(value)) {
			return false;
		}
		
		return pattern.matcher(value).matches();
	}

}
