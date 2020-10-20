package br.com.acdev.msreservas.gateway.repository.springdata;

import br.com.acdev.msreservas.core.entity.Reserva;
import br.com.acdev.msreservas.gateway.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReservaRepositoryGateway implements ReservaRepository {

    @Autowired
    private ReservaJpaRepository repository;

    @Override
    public Reserva salvar(Reserva reserva) {
        return repository.save(reserva);
    }

    @Override
    public List<Reserva> consultarComFiltros(Reserva reserva) {
        return repository.findByFilter(reserva.getRecursoId(), reserva.getClienteId());
    }
}
