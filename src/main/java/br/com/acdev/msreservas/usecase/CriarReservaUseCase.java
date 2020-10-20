package br.com.acdev.msreservas.usecase;

import br.com.acdev.msreservas.core.entity.Reserva;
import br.com.acdev.msreservas.core.entity.StatusReserva;
import br.com.acdev.msreservas.gateway.event.ReservaEventProducer;
import br.com.acdev.msreservas.gateway.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarReservaUseCase {

    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private ReservaEventProducer reservaEventProducer;

    public Reserva executar(Reserva reserva) {
        reserva.setStatus(StatusReserva.CRIADA);
        reserva = reservaRepository.salvar(reserva);
        reservaEventProducer.executar(reserva);
        return reserva;
    }
}
