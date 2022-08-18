package com.ltk.api.solar.tos.city.response;

import com.ltk.api.solar.models.City;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CityResponseTo {

    private String id;

    private String name;

    private BigDecimal lat;

    private BigDecimal lng;

    private String ibgeCode;

    private StateResponseTO state;

    public CityResponseTo setValues(City city) {

        this.id = city.getId();
        this.name = city.getName();
        this.lat = city.getLat();
        this.lng = city.getLng();
        this.ibgeCode = city.getIbgeCode();

        if(city.getState() != null) {
            this.state = new StateResponseTO().setValues(city.getState());
        }

        return this;
    }

}
