package com.ltk.api.solar.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ETensao {

    T127(127, 1),
    T220(220, 2),
    T380(380, 3);

    private final int valor;

    private final int numeroFases;

}
