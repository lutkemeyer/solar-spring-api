package com.ltk.api.solar.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "CITY")
public class City extends BaseEntity {

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "IDSTATE", nullable = false, foreignKey = @ForeignKey(name = "ESTADO_FK"))
    private State state;

    @Column(name = "LAT", nullable = false, precision = 8, scale = 6)
    private BigDecimal lat;

    @Column(name = "LNG", nullable = false, precision = 8, scale = 6)
    private BigDecimal lng;

    @Column(name = "IBGECODE", length = 7)
    private String ibgeCode;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "IDREGIAOGEOGRAFICAIMEDIATA")
//    private RegiaoGeograficaImediata regiaoGeograficaImediata;
//
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "IDREGIAOGEOGRAFICAINTERMEDIARIA")
//    private RegiaoGeograficaIntermediaria regiaoGeograficaIntermediaria;

}
