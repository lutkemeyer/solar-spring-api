package com.ltk.api.solar.models.generators;

import com.ltk.api.solar.tools.Uuid;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class UuidGenerator implements IdentifierGenerator {

    public static final String STRATEGY_PATH = "com.ltk.api.solar.models.generators.UuidGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return Uuid.generate();
    }

}
