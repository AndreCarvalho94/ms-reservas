package br.com.acdev.msreservas.config.confluent;

import br.com.acdev.msreservas.core.dto.ReservaEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


@Configuration
public class ConfluentKafka {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Bean
    public ProducerFactory<String, ReservaEvent> producerFactory() {
        return new DefaultKafkaProducerFactory(kafkaProperties.getProperties());
    }

    @Bean
    public KafkaTemplate<String, ReservaEvent> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
