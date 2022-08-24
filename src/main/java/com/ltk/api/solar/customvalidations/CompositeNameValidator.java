package com.ltk.api.solar.customvalidations;

import com.ltk.api.solar.tools.util.StringUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CompositeNameValidator implements ConstraintValidator<CompositeNameConstraint, String> {

    @Override
    public void initialize(CompositeNameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        if(field == null) {
            return false;
        }
        String[] splitted = field.split("\\s+");
        return splitted.length >= 2 && StringUtil.trimmedNe(splitted[0]) && StringUtil.trimmedNe(splitted[1]);
    }

}
