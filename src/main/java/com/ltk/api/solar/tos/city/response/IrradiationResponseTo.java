package com.ltk.api.solar.tos.city.response;

import com.ltk.api.solar.models.Irradiation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IrradiationResponseTo {

    private String id;
    
    private BigDecimal lat;
    
    private BigDecimal lng;
    
    private BigDecimal jan;
    
    private BigDecimal feb;
    
    private BigDecimal mar;
    
    private BigDecimal apr;
    
    private BigDecimal may;
    
    private BigDecimal jun;
    
    private BigDecimal jul;
    
    private BigDecimal aug;
    
    private BigDecimal sep;
    
    private BigDecimal oct;
    
    private BigDecimal nov;
    
    private BigDecimal dec;

    public IrradiationResponseTo setValues(Irradiation irradiation) {

        this.id = irradiation.getId();
        
        this.lat = irradiation.getLat();
        this.lng = irradiation.getLng();
        
        this.jan = irradiation.getJan();
        this.feb = irradiation.getFeb();
        this.mar = irradiation.getMar();
        this.apr = irradiation.getApr();
        this.may = irradiation.getMay();
        this.jun = irradiation.getJun();
        this.jul = irradiation.getJul();
        this.aug = irradiation.getAug();
        this.sep = irradiation.getSep();
        this.oct = irradiation.getOct();
        this.nov = irradiation.getNov();
        this.dec = irradiation.getDec();

        return this;
    }

}
