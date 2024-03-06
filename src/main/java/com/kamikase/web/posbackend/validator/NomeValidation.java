package com.kamikase.web.posbackend.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NomeValidator.class)
public @interface NomeValidation {
    String message() default "Nome não é válido.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
