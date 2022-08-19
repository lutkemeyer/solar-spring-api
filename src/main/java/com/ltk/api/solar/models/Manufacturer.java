package com.ltk.api.solar.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "MANUFACTURER")
public class Manufacturer extends BaseEntity {

    @Column(name = "NAME", nullable = false, length = 150)
    private String name;
    
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="IDMANUFACTURER")
//    private Set<Module> modules;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="IDMANUFACTURER")
//    private Set<Module> modules;
    
}
