package br.com.acdev.msreservas.core.dto;

import br.com.acdev.msreservas.core.entity.StatusReserva;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservaEvent {

    private Long reservaId;
    private Long recursoId;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private StatusReserva status;
    private BigDecimal valorTotal;
}
