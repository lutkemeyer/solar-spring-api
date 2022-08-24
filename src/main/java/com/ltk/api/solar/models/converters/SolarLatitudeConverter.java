package com.ltk.api.solar.models.converters;

import com.ltk.api.solar.tools.types.SolarLatitude;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.math.BigDecimal;

@Converter
@NoArgsConstructor
public class SolarLatitudeConverter implements AttributeConverter<SolarLatitude, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(SolarLatitude attribute) {
        return attribute;
    }

    @Override
    public SolarLatitude convertToEntityAttribute(BigDecimal dbData) {
        return new SolarLatitude(dbData);
    }

}
