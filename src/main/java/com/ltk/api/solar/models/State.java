package com.ltk.api.solar.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "STATE")
public class State extends BaseEntity {

    @Column(name = "NAME", length = 150, nullable = false, unique = true)
    private String name;

    @Column(name = "UF", length = 2, nullable = false, unique = true)
    private String uf;

    @ManyToOne
    @JoinColumn(name = "IDCOUNTRY", nullable = false, foreignKey = @ForeignKey(name = "PAIS_FK"))
    private Country country;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDCAPITAL", unique = true, nullable = false, foreignKey = @ForeignKey(name = "CIDADE_CAPITAL_FK"))
    private City capital;

    @Column(name = "IBGECODE", length = 7)
    private String ibgeCode;

}

