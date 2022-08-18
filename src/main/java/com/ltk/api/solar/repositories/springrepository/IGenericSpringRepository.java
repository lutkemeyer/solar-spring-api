package com.ltk.api.solar.repositories.springrepository;

import com.ltk.api.solar.models.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericSpringRepository<ENTIDADE extends BaseEntity> extends JpaRepository<ENTIDADE, String> {
	
}
