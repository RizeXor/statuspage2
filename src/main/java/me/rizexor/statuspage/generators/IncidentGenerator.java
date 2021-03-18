package me.rizexor.statuspage.generators;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class IncidentGenerator implements IdentifierGenerator {

    public static final String generatorName = "IncidentGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {
        Random random = new Random();
        String charList = "abcdefghijklmnopqrstuvwxyz1234567890";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            stringBuilder.append(charList.charAt(random.nextInt(charList.length())));
        }

        return stringBuilder.toString();
    }

}
