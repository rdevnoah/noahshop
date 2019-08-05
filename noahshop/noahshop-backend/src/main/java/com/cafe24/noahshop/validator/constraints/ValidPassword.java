package com.cafe24.noahshop.validator.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cafe24.noahshop.validator.PasswordValidator;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = PasswordValidator.class)
public @interface ValidPassword {
	String message() default "8자 이상 16자 이하로 특수문자를 반드시 포함해야합니다.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
