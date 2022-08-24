package com.ltk.api.solar.tos.city.request;

import com.ltk.api.solar.customvalidations.CompositeNameConstraint;
import com.ltk.api.solar.customvalidations.LatitudeConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CityRequestTo {

    @CompositeNameConstraint
    @NotBlank
    private String name;

    @LatitudeConstraint
    private BigDecimal lat;

//    @Siz
    private BigDecimal lng;

    @NotBlank
    private String ibgeCode;

}
