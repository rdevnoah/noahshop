package com.cafe24.noahshop.validator.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cafe24.noahshop.validator.TelValidator;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = TelValidator.class)
public @interface ValidTel {
	String message() default "잘못된 전화번호 양식입니다. XXX-XXXX-XXXX 와 같은 양식으로 입력하세요";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {}; 
}
