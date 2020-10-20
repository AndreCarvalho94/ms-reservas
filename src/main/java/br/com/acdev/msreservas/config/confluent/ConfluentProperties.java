package br.com.acdev.msreservas.config.confluent;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "confluent-cloud")
public class ConfluentProperties {

    @NestedConfigurationProperty
    private ConnectionInfo broker;

    private String topico;

    @Data
    public static class ConnectionInfo {
        private String url;
        private String keyId;
        private String token;
        private String secret;
    }
}
