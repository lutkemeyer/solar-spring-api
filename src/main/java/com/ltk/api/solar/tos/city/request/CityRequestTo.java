package com.ltk.api.solar.tos.city.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CityRequestTo {

    @NotBlank
    private String name;

//    @Min(2)
    private BigDecimal latitude;

//    @Siz
    private BigDecimal longitude;

    @NotBlank
    private String ibgeCode;

}
