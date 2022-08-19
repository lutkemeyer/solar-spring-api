package com.ltk.api.solar.tos.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentialsRequestTO {
	
	@NotBlank
	@JsonProperty
	private String username;
	
	@NotBlank
	@JsonProperty
	private String password;
	
}
