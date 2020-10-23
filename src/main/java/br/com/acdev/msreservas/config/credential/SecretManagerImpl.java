package br.com.acdev.msreservas.config.credential;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class SecretManagerImpl implements SecretManager {


    @Autowired
    private Environment environment;

    public Credencial getCredencial(String secretId) {
        String key = environment.getProperty(secretId + "_KEY");
        String secret = environment.getProperty(secretId + "_SECRET");
        return Credencial.builder().
                key(key).
                secret(secret).
                id(secretId).build();
    }
}
