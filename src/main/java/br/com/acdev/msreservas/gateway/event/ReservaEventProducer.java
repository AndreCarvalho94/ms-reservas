package br.com.acdev.msreservas.gateway.event;

import br.com.acdev.msreservas.core.entity.Reserva;

public interface ReservaEventProducer {

    void executar(Reserva reserva);

}
