package com.ltk.api.solar.tos.user.request;

import com.ltk.api.solar.customvalidations.CompositeNameConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestTo {

    @NotBlank
    @CompositeNameConstraint
    private String name;

}
