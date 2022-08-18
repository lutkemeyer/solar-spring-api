package com.ltk.api.solar.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltk.api.solar.models.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.ltk.api.solar.utils.SecurityConstants.EXPIRATION_TIME;
import static com.ltk.api.solar.utils.SecurityConstants.SECRET;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
		
		setFilterProcessesUrl("/api/login");
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
		try {
			User creds = new ObjectMapper().readValue(req.getInputStream(), User.class);
			
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getLogin(), creds.getPassword(), new ArrayList<>()));
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException {
		
		String token = JWT.create()
				.withSubject(((User) auth.getPrincipal()).getLogin())
				.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.sign(Algorithm.HMAC512(SECRET.getBytes()));
		
		String body = ((User) auth.getPrincipal()).getLogin() + " " + token;
		
		res.getWriter()
				.write(body);
		res.getWriter()
				.flush();
	}
	
}
