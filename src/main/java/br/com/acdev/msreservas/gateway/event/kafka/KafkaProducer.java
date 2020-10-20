package br.com.acdev.msreservas.gateway.event.kafka;

import br.com.acdev.msreservas.config.confluent.ConfluentProperties;
import br.com.acdev.msreservas.core.converter.ReservaDtoConverter;
import br.com.acdev.msreservas.core.dto.ReservaEvent;
import br.com.acdev.msreservas.core.entity.Reserva;
import br.com.acdev.msreservas.gateway.event.ReservaEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class KafkaProducer implements ReservaEventProducer {

    @Autowired
    private KafkaTemplate<String, ReservaEvent> producer;

    @Autowired
    private ConfluentProperties confluentProperties;

    @Autowired
    private ReservaDtoConverter reservaDtoConverter;

    public void executar(Reserva reserva) {
        ReservaEvent reservaEvent = reservaDtoConverter.toEvent(reserva);
        producer.send(confluentProperties.getTopico(), reservaEvent);
        producer.flush();
    }
}
