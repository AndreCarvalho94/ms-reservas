package br.com.acdev.msreservas.core.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    private Long recursoId;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private BigDecimal valorUnitario;
    private BigDecimal valorTotal;
    private int quantidadeDependentes;
    @Enumerated(EnumType.STRING)
    private StatusReserva status;


}
