package com.ltk.api.solar.tos.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCredentialsRequestTO {
	
	@JsonProperty
	private String username;
	
	@JsonProperty
	private String password;
	
}
