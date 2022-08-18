package com.ltk.api.solar.repositories.generic;

import com.ltk.api.solar.models.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.lang.reflect.ParameterizedType;

public class GenericRepositoryImpl<ENTIDADE extends BaseEntity> {
	
	@Autowired
	private EntityManager entityManager;
	
	private Class<ENTIDADE> entityClass;
	
	@SuppressWarnings("unchecked")
	public GenericRepositoryImpl() {
		if(getClass().getGenericSuperclass() instanceof ParameterizedType) {
			this.entityClass = (Class<ENTIDADE>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
	}
	
	/**
	 * Create a TypedQuery with this entityClass
	 */
	@NotNull
	protected TypedQuery<ENTIDADE> createTypedQuery(StringBuilder sb) {
		return createTypedQuery(sb.toString());
	}
	
	/**
	 * Create a TypedQuery with this entityClass
	 */
	@NotNull
	protected TypedQuery<ENTIDADE> createTypedQuery(String sql) {
		return entityManager.createQuery(sql, entityClass);
	}
	
	@Nullable
	protected ENTIDADE getNullableSingleResult(TypedQuery<ENTIDADE> tQuery) {
		try {
			return tQuery.setMaxResults(1)
					.getSingleResult();
		} catch(NoResultException noResultException) {
			return null;
		}
	}
	
}
