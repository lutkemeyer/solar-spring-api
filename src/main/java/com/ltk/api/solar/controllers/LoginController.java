package com.ltk.api.solar.controllers;

import com.ltk.api.solar.config.authentication.JwtTokenUtil;
import com.ltk.api.solar.tos.login.TokenResponseTO;
import com.ltk.api.solar.tos.login.UserCredentialsRequestTO;
import com.ltk.api.solar.tools.util.LocalDateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;
	
	@RequestMapping(value = "/login",
	                method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody UserCredentialsRequestTO userCredentialsRequestTO) throws Exception {
		
		Objects.requireNonNull(userCredentialsRequestTO);
		Objects.requireNonNull(userCredentialsRequestTO.getUsername());
		Objects.requireNonNull(userCredentialsRequestTO.getPassword());
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredentialsRequestTO.getUsername(), userCredentialsRequestTO.getPassword()));
			
		} catch(DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch(BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		UserDetails userDetails = jwtInMemoryUserDetailsService.loadUserByUsername(userCredentialsRequestTO.getUsername());
		
		String token = jwtTokenUtil.generateToken(userDetails);
		
		LocalDateTime expirationDateFromToken = LocalDateTimeUtil.toLocalDateTime(jwtTokenUtil.getExpirationDateFromToken(token));
		
		TokenResponseTO responseTO = TokenResponseTO.builder()
				.token(token)
				.expiration(expirationDateFromToken)
				.build();
		
		return ResponseEntity.ok(responseTO);
	}
	
}
