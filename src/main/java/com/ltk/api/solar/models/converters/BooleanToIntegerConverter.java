package com.ltk.api.solar.models.converters;

import lombok.NoArgsConstructor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
@NoArgsConstructor
public class BooleanToIntegerConverter implements AttributeConverter<Boolean, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Boolean attribute) {
        return attribute != null && attribute ? 1 : 0;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer dbData) {
        return dbData != null && dbData == 1;
    }

}
