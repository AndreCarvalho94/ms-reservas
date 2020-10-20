package br.com.acdev.msreservas.config.confluent;


import br.com.acdev.msreservas.config.credential.Cofre;
import br.com.acdev.msreservas.config.credential.Credencial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaProperties {

    @Autowired
    private Cofre cofre;

    @Autowired
    private ConfluentProperties confluentProperties;

    public Properties getProperties() {
        this.configurarCredenciais();
        Properties properties = new Properties();
        properties.setProperty("sasl.mechanism", "PLAIN");
        properties.setProperty("bootstrap.servers", confluentProperties.getBroker().getUrl());
        properties.setProperty("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule\n" +
                "            required username=\"" + confluentProperties.getBroker().getToken() + "\"\n" +
                "            password=\"" + confluentProperties.getBroker().getSecret() + "\";");
        properties.setProperty("security.protocol", "SASL_SSL");
        properties.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.setProperty("value.serializer", "org.springframework.kafka.support.serializer.JsonSerializer");
        return properties;
    }

    private void configurarCredenciais() {
        Credencial credencial = cofre.getCredencial(confluentProperties.getBroker().getKeyId());
        confluentProperties.getBroker().setToken(credencial.getKey());
        confluentProperties.getBroker().setSecret(credencial.getSecret());
    }

}
