package com.ltk.api.solar.services;

import com.ltk.api.solar.models.User;
import com.ltk.api.solar.repositories.springrepository.IUserSpringRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Log4j2
@Service
@AllArgsConstructor
public class UserService {
	
	private final IUserSpringRepository repository;
	
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
