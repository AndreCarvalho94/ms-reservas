package br.com.acdev.msreservas.config.credential;

public interface SecretManager {
    Credencial getCredencial(String secretId);
}
