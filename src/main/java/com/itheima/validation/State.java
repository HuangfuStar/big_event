package com.itheima.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StateValidator.class)
public @interface State {
    String message() default "Invalid state";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
