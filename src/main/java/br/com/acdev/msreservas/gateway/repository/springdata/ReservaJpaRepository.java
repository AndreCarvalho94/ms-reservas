package br.com.acdev.msreservas.gateway.repository.springdata;

import br.com.acdev.msreservas.core.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaJpaRepository extends JpaRepository<Reserva, Long> {


    @Query("  SELECT  r" +
            "   FROM  Reserva r" +
            "  WHERE  " +
            "         ( :recursoId  is null OR r.recursoId   = :recursoId )" +
            "    AND  ( :clienteId  is null OR r.clienteId   = :clienteId )")
    public List<Reserva> findByFilter(Long recursoId, Long clienteId);
}
