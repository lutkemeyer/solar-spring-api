package com.ltk.api.solar.customvalidations;

import com.ltk.api.solar.tools.util.BigDecimalUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class LatitudeValidator implements ConstraintValidator<LatitudeConstraint, Number> {

    @Override
    public void initialize(LatitudeConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Number number, ConstraintValidatorContext constraintValidatorContext) {
        if(number == null) {
            return false;
        }
        BigDecimal val = BigDecimalUtil.parseOrZero(number);
        return BigDecimalUtil.betweenIncl(val, -90, 90);
    }

}
