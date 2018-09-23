package com.lanhu.work.validator.rule;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserTypeValidator implements
		ConstraintValidator<UserType, String> {
	private final String[] ALL_VALUES = { "1","2","3","4"};

	public void initialize(UserType userType) {
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null || Arrays.asList(ALL_VALUES).contains(value))
			return true;
		return false;
	}


}
