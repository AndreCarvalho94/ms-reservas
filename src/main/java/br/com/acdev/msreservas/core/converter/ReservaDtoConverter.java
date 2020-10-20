package br.com.acdev.msreservas.core.converter;

import br.com.acdev.msreservas.core.dto.ReservaEvent;
import br.com.acdev.msreservas.core.entity.Reserva;
import br.com.acdev.msreservas.core.request.ReservaRequest;
import br.com.acdev.msreservas.core.request.ReservaResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservaDtoConverter {

    public Reserva fromRequest(Long clienteId, ReservaRequest reservaRequest) {
        return Reserva.builder().
                clienteId(clienteId).
                dataInicio(reservaRequest.getDataInicio()).
                dataFim(reservaRequest.getDataFim()).
                quantidadeDependentes(reservaRequest.getQuantidadeDependentes()).
                recursoId(reservaRequest.getRecursoId()).
                valorTotal(reservaRequest.getValorTotal()).
                valorUnitario(reservaRequest.getValorUnitario()).
                build();
    }

    public ReservaResponse toResponse(Reserva reserva) {
        return ReservaResponse.builder().
                clienteId(reserva.getClienteId()).
                dataFim(reserva.getDataFim()).
                dataInicio(reserva.getDataInicio()).
                id(reserva.getId()).
                quantidadeDependentes(reserva.getQuantidadeDependentes()).
                recursoId(reserva.getRecursoId()).
                status(reserva.getStatus()).
                valorTotal(reserva.getValorTotal()).
                valorUnitario(reserva.getValorUnitario()).build();
    }

    public List<ReservaResponse> toResponse(List<Reserva> reservas){
        return reservas.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public ReservaEvent toEvent(Reserva reserva) {
        return ReservaEvent.builder().
                status(reserva.getStatus()).
                dataFim(reserva.getDataFim()).
                dataInicio(reserva.getDataInicio()).
                recursoId(reserva.getRecursoId()).
                reservaId(reserva.getId()).
                valorTotal(reserva.getValorTotal()).build();

    }
}
