package com.ltk.api.solar.models;

import com.ltk.api.solar.models.generators.UuidGenerator;
import com.ltk.api.solar.models.converters.BooleanToIntegerConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @EqualsAndHashCode.Include
    @GenericGenerator(name = "string_based_custom_sequence", strategy = UuidGenerator.STRATEGY_PATH)
    @GeneratedValue(generator = "string_based_custom_sequence")
    @Column(name = "ID", length = 32)
    private String id;

    @Convert(converter = BooleanToIntegerConverter.class)
    @Column(name = "ACTIVE", nullable = false)
    private boolean active = true;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(": id=\"").append(getId()).append("\"");
        return sb.toString();
    }

}
