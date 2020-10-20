package br.com.acdev.msreservas.usecase;


import br.com.acdev.msreservas.core.entity.Reserva;
import br.com.acdev.msreservas.gateway.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultarReservasUseCase {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> executar(Reserva reserva) {
        return reservaRepository.consultarComFiltros(reserva);
    }
}
