package com.ltk.api.solar.customvalidations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompositeNameValidator implements ConstraintValidator<CompositeNameConstraint, String> {

    @Override
    public void initialize(CompositeNameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return field == null || field.split(" ").length >= 2;
    }

}
