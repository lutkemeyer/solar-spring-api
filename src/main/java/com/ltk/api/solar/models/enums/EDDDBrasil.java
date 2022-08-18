package com.ltk.api.solar.models.enums;

import com.ltk.api.solar.models.enums.interfaces.IEnumDescriptor;
import com.ltk.api.solar.models.enums.interfaces.IStoredEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EDDDBrasil implements IEnumDescriptor, IStoredEnum {

    DDD_11("11"),
    DDD_12("12"),
    DDD_13("13"),
    DDD_14("14"),
    DDD_15("15"),
    DDD_16("16"),
    DDD_17("17"),
    DDD_18("18"),
    DDD_19("19"),
    DDD_21("21"),
    DDD_22("22"),
    DDD_24("24"),
    DDD_27("27"),
    DDD_28("28"),
    DDD_31("31"),
    DDD_32("32"),
    DDD_33("33"),
    DDD_34("34"),
    DDD_35("35"),
    DDD_37("37"),
    DDD_38("38"),
    DDD_41("41"),
    DDD_42("42"),
    DDD_43("43"),
    DDD_44("44"),
    DDD_45("45"),
    DDD_46("46"),
    DDD_47("47"),
    DDD_48("48"),
    DDD_49("49"),
    DDD_51("51"),
    DDD_53("53"),
    DDD_54("54"),
    DDD_55("55"),
    DDD_61("61"),
    DDD_62("62"),
    DDD_63("63"),
    DDD_64("64"),
    DDD_65("65"),
    DDD_66("66"),
    DDD_67("67"),
    DDD_68("68"),
    DDD_69("69"),
    DDD_71("71"),
    DDD_73("73"),
    DDD_74("74"),
    DDD_75("75"),
    DDD_77("77"),
    DDD_79("79"),
    DDD_81("81"),
    DDD_82("82"),
    DDD_83("83"),
    DDD_84("84"),
    DDD_85("85"),
    DDD_86("86"),
    DDD_87("87"),
    DDD_88("88"),
    DDD_89("89"),
    DDD_91("91"),
    DDD_92("92"),
    DDD_93("93"),
    DDD_94("94"),
    DDD_95("95"),
    DDD_96("96"),
    DDD_97("97"),
    DDD_98("98"),
    DDD_99("99");

    private final String numero;

    @Override
    public String getDescricao() {
        return numero;
    }

    @Override
    public String getKey() {
        return name();
    }
}
