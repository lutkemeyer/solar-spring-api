package com.ltk.api.solar.repositories.springrepository;

import com.ltk.api.solar.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserSpringRepository extends IGenericSpringRepository<User> {

    Optional<User> findByIdAndTimeRemovedIsNull(String id);

    boolean existsByLoginEqualsAndPasswordEqualsAndTimeRemovedIsNull(String login, String password);

    Optional<User> findByLoginEqualsAndPasswordEqualsAndTimeRemovedIsNull(String login, String password);
    
    Optional<User> findByLoginEqualsAndTimeRemovedIsNull(String login);

    int countByTimeRemovedIsNull();

}
