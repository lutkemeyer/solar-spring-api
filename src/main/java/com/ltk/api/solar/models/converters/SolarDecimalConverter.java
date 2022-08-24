package com.ltk.api.solar.models.converters;

import com.ltk.api.solar.tools.types.SolarDecimal;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeConverter;
import java.math.BigDecimal;

@NoArgsConstructor
public class SolarDecimalConverter implements AttributeConverter<SolarDecimal, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(SolarDecimal attribute) {
        return attribute;
    }

    @Override
    public SolarDecimal convertToEntityAttribute(BigDecimal dbData) {
        return new SolarDecimal(dbData);
    }

}
