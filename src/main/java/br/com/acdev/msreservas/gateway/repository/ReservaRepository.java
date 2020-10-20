package br.com.acdev.msreservas.gateway.repository;

import br.com.acdev.msreservas.core.entity.Reserva;

import java.util.List;

public interface ReservaRepository {

    Reserva salvar(Reserva reserva);

    List<Reserva> consultarComFiltros(Reserva reserva);
}
