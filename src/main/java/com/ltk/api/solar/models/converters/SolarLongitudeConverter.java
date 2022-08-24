package com.ltk.api.solar.models.converters;

import com.ltk.api.solar.tools.types.SolarLongitude;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.math.BigDecimal;

@Converter
@NoArgsConstructor
public class SolarLongitudeConverter implements AttributeConverter<SolarLongitude, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(SolarLongitude attribute) {
        return attribute;
    }

    @Override
    public SolarLongitude convertToEntityAttribute(BigDecimal dbData) {
        return new SolarLongitude(dbData);
    }

}
