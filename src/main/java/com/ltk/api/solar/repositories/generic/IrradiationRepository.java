package com.ltk.api.solar.repositories.generic;

import com.ltk.api.solar.models.Irradiation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Log4j2
@Repository
public class IrradiationRepository extends GenericRepositoryImpl<Irradiation> {

	@NotNull
	public Irradiation findByLatLng(BigDecimal lat, BigDecimal lng) {

//		LOGGER.debug(StrUtil.injectStringify("Consultando irradiação por latitude e longitude: {0} {1}", latitude, longitude));

		StringBuilder sb = new StringBuilder();
		sb.append("select i ");
		sb.append("from Irradiation i ");
		sb.append("order by function('distance', :lat, i.lat, :lng, i.lng) asc ");

		TypedQuery<Irradiation> tQuery = createTypedQuery(sb);
		tQuery.setParameter("lat", lat);
		tQuery.setParameter("lng", lng);

		Irradiation irradiation = getNullableSingleResult(tQuery);

//		if(irradiacao != null) {
//			LOGGER.debug(StrUtil.injectStringify("Encontrou a irradiacao mais proxima: latitude e longitude: {0} {1}", irradiacao.getLatitude(), irradiacao.getLongitude()));
//		} else {
//			LOGGER.debug("Não encontrou nenhuma irradiacao");
//		}

		return irradiation;
	}

}
