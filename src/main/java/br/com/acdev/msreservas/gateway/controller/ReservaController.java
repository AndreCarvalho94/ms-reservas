package br.com.acdev.msreservas.gateway.controller;


import br.com.acdev.msreservas.core.converter.ReservaDtoConverter;
import br.com.acdev.msreservas.core.entity.Reserva;
import br.com.acdev.msreservas.core.request.ReservaRequest;
import br.com.acdev.msreservas.core.request.ReservaResponse;
import br.com.acdev.msreservas.core.request.UriUtils;
import br.com.acdev.msreservas.usecase.ConsultarReservasUseCase;
import br.com.acdev.msreservas.usecase.CriarReservaUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/reservas")
public class ReservaController {


    @Autowired
    private CriarReservaUseCase criarReservaUseCase;
    @Autowired
    private ConsultarReservasUseCase consultarReservasUseCase;
    private final ReservaDtoConverter reservaDtoConverter;
    private final UriUtils uriUtils;

    @PostMapping("/{clienteId}")
    public ResponseEntity<ReservaResponse> criarReserva(@PathVariable Long clienteId,
                                                        @RequestBody ReservaRequest reservaRequest,
                                                        UriComponentsBuilder uriBuilder) {
        Reserva reserva = reservaDtoConverter.fromRequest(clienteId, reservaRequest);
        reserva = criarReservaUseCase.executar(reserva);
        return ResponseEntity.created(uriUtils.getUri(reserva, uriBuilder)).body(reservaDtoConverter.toResponse(reserva));

    }

    @GetMapping("/")
    public ResponseEntity<List<ReservaResponse>> consultarReservas(@RequestParam(required = false) Long clientId,
                                                                   @RequestParam(required = false) Long recursoId) {
        Reserva reserva = Reserva.builder().
                clienteId(clientId).
                recursoId(recursoId).build();
        List<Reserva> reservas = consultarReservasUseCase.executar(reserva);
        return ResponseEntity.ok(reservaDtoConverter.toResponse(reservas));
    }
}
