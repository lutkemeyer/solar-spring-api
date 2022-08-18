package com.ltk.api.solar.utils;

import com.ltk.api.solar.config.UserDetailsImpl;
import com.ltk.api.solar.models.User;
import com.ltk.api.solar.services.JwtUserService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {
	
	private final JwtUserService jwtUserDetailsService;
	
	private final JwtTokenUtil jwtTokenUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		// JWT Token is in the form "Bearer token". Remove Bearer word and get
		// only the Token
		if (requestTokenHeader != null) {
			if (requestTokenHeader.startsWith("Bearer ")) {
				jwtToken = requestTokenHeader.substring(7);
				try {
					username = jwtTokenUtil.getUsernameFromToken(jwtToken);
				} catch (IllegalArgumentException e) {
					log.warn("Unable to get JWT Token");
				} catch (ExpiredJwtException e) {
					log.warn("JWT Token has expired");
				} catch(Exception e) {
					log.warn(e.getMessage());
				}
			} else {
				log.error("JWT Token does not begin with Bearer String");
			}
		}
		
		// Once we get the token validate it.
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);
			
			// if token is valid configure Spring Security to manually set
			// authentication
			if (jwtTokenUtil.isValidToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, userDetails.getPassword(), userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		
		
		UserDetailsImpl userDetails = new UserDetailsImpl();
		userDetails.setUser(new User());
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, userDetails.getPassword(), userDetails.getAuthorities());
		usernamePasswordAuthenticationToken
				.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		
		chain.doFilter(request, response);
	}
}
