package com.ltk.api.solar.services;

import com.ltk.api.solar.models.User;
import com.ltk.api.solar.repositories.springrepository.IUserSpringRepository;
import com.ltk.api.solar.tos.login.TokenResponseTO;
import com.ltk.api.solar.tos.login.UserCredentialsRequestTO;
import com.ltk.api.solar.utils.JwtTokenUtil;
import com.ltk.api.solar.utils.LocalDateTimeUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Log4j2
@Service
@AllArgsConstructor
public class LoginService {
	
	private final IUserSpringRepository repository;
	
	@Autowired
	private JwtUserService jwtUserService;
	
	private final AuthenticationManager authenticationManager;
	
	public TokenResponseTO signIn(UserCredentialsRequestTO userCredentialsRequestTO) {
		
		log.info("Try to authenticate login: {} password: {}", userCredentialsRequestTO.getUsername(), userCredentialsRequestTO.getPassword());
		
		userCredentialsRequestTO.setPassword(new BCryptPasswordEncoder().encode(userCredentialsRequestTO.getPassword()));
		
		log.info("password: {}", userCredentialsRequestTO.getPassword());
		
		String token = authenticate(userCredentialsRequestTO.getUsername(), userCredentialsRequestTO.getPassword());
		
		log.info("Authentication successful for {}", userCredentialsRequestTO.getUsername());
		
		LocalDateTime expirationDateFromToken = LocalDateTimeUtil.toLocalDateTime(JwtTokenUtil.getExpirationDateFromToken(token));
		
		return TokenResponseTO.builder()
				.token(token)
				.expiration(expirationDateFromToken)
				.build();
	}
	
	private String authenticate(String login, String password) {
		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password));
		return createToken(((User) auth.getPrincipal()).getLogin());
	}
	
	private String createToken(String username) {
		final UserDetails userDetails = jwtUserService.loadUserByUsername(username);
		return JwtTokenUtil.generateToken(userDetails);
	}
	
	public Optional<User> findByIdAndActiveIsTrue(String id) {
		return repository.findByIdAndActiveIsTrue(id);
	}
	
	public boolean existsById(String id) {
		return repository.existsById(id);
	}
	
	public User save(User user) {
		return repository.save(user);
	}
	
	@Transactional
	public void inactiveById(String id) {
		repository.findById(id)
				.ifPresent(user -> {
					user.setActive(false);
				});
	}
	
}
