package com.ltk.api.solar.tos.login;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenResponseTO {
	
	private String token;
	
	private LocalDateTime expiration;
	
}
