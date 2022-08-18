package com.ltk.api.solar.tos.city.response;

import com.ltk.api.solar.models.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StateResponseTO {

    private String id;

    private String name;

    private String uf;

    public StateResponseTO setValues(State state) {
        if(state == null) {
            return this;
        }
        this.id = state.getId();
        this.name = state.getName();
        this.uf = state.getUf();
        return this;
    }
}
