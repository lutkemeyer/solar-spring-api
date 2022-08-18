package com.ltk.api.solar.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "COUNTRY")
public class Country extends BaseEntity {

    @Column(name = "BRAZILIANNAME", length = 50, nullable = false)
    private String brazilianName;

    @Column(name = "INTERNATIONALNAME", length = 50, nullable = false)
    private String internationalName;

//    @Convert(converter = EPaisIso2Converter.class)
//    @Column(name = "ISO2", length = 2, unique = true, nullable = false)
//    private EPaisIso2 iso2;
//
//    @Convert(converter = EPaisIso3Converter.class)
//    @Column(name = "ISO3", length = 3)
//    private EPaisIso3 iso3;

    @Column(name = "DDI", length = 5)
    private String ddi;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="IDCOUNTRY")
    private Set<State> states;

}
