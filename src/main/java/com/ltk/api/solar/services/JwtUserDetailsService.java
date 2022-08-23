package com.ltk.api.solar.services;

import com.ltk.api.solar.models.User;
import com.ltk.api.solar.repositories.springrepository.IUserSpringRepository;
import com.ltk.api.solar.tos.login.UserDetailsImplTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
	
	private final IUserSpringRepository iUserSpringRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = iUserSpringRepository.findByLoginEqualsAndTimeRemovedIsNull(username);
		
		if(user.isEmpty()) {
			// find by email
		}
		
		if(user.isPresent()) {
			return UserDetailsImplTO.builder()
					.user(user.get())
					.roles(List.of(new SimpleGrantedAuthority("ADMIN")))
					.build();
		} else {
			throw new UsernameNotFoundException("User not found with login: " + username);
		}
	}
	
}

