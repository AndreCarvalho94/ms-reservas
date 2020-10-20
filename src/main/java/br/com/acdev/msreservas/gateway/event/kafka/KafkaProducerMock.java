package br.com.acdev.msreservas.gateway.event.kafka;

import br.com.acdev.msreservas.core.entity.Reserva;
import br.com.acdev.msreservas.gateway.event.ReservaEventProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Slf4j
@Primary
@Component
@Profile("test")
public class KafkaProducerMock implements ReservaEventProducer {

    @Override
    public void executar(Reserva reserva) {
        log.info("Mockando o comportamento do kafka");
    }

}
