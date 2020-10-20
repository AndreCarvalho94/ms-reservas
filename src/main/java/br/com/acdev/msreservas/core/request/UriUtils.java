package br.com.acdev.msreservas.core.request;

import br.com.acdev.msreservas.core.entity.Reserva;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class UriUtils {
    public URI getUri(Reserva reserva, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/reservas/{id}").buildAndExpand(reserva.getId()).toUri();
    }
}
