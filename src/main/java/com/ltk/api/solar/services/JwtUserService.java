package com.ltk.api.solar.services;

import com.ltk.api.solar.models.User;
import com.ltk.api.solar.repositories.springrepository.IUserSpringRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtUserService implements UserDetailsService {
	
	private final IUserSpringRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String input) throws UsernameNotFoundException {
		Optional<User> userOptional = userRepository.findByLoginEqualsAndActiveIsTrue(input);
		if(userOptional.isEmpty()) {
//			userOptional = userRepository.findByEmail(input);
		}
		
		if(userOptional.isEmpty()) {
			throw new AuthenticationCredentialsNotFoundException("User not found with input: " + input);
		}
		
		User user = userOptional.get();
		return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthorities(user));
	}
	
	private static List<GrantedAuthority> getAuthorities(User user) {
		return Arrays.asList(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("STAFF"), new SimpleGrantedAuthority("USER"));
		//		return user.getRoles().stream().map(AccountRole::getRole).map(AccountRoleEnum::toString)
		//				.map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	
}

