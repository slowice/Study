package com.lanhu.work.validator.rule;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SexValidator implements
		ConstraintValidator<Sex, Integer> {
	private final Integer[] ALL_VALUES = { 0,1,2};

	public void initialize(Sex sex) {
	}

	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if (value == null || Arrays.asList(ALL_VALUES).contains(value))
			return true;
		return false;
	}


}
