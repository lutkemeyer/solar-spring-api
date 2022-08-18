package com.ltk.api.solar.models.enums;

import com.ltk.api.solar.models.enums.interfaces.IEnumDescriptor;
import com.ltk.api.solar.models.enums.interfaces.IStoredEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ESexo implements IEnumDescriptor, IStoredEnum {

    MASCULINO("M", "Masculino"),
    FEMININO("F", "Feminino");

    private final String sigla;

    private final String descricao;

    @Override
    public String getKey() {
        return sigla;
    }
}
