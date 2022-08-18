package com.ltk.api.solar.repositories.springrepository;

import com.ltk.api.solar.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserSpringRepository extends IGenericSpringRepository<User> {

    Optional<User> findByIdAndActiveIsTrue(String id);

    boolean existsByLoginEqualsAndPasswordEqualsAndActiveIsTrue(String login, String password);

    Optional<User> findByLoginEqualsAndPasswordEqualsAndActiveIsTrue(String login, String password);
    
    Optional<User> findByLoginEqualsAndActiveIsTrue(String login);

    int countByActiveIsTrue();

}
