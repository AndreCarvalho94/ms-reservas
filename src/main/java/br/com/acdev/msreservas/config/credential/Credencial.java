package br.com.acdev.msreservas.config.credential;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Credencial {

    private String key;
    private String secret;
    private String keyId;

}
