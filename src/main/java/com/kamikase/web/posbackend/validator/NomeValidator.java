package com.kamikase.web.posbackend.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class NomeValidator implements ConstraintValidator<NomeValidation, String> {

    private static final List<String> nomesProibidos = Arrays.asList("Flamengo", "Palmeiras", "Fluminense", "Botafogo");
    private String message;

    @Override
    public void initialize(NomeValidation constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        if (!nomesProibidos.contains(nome)) {
            return true;
        }

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(message + " Nome proibido: " + nome)
                .addConstraintViolation();
        return false;
    }
}
