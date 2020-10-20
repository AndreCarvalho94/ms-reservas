package br.com.acdev.msreservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class MsReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsReservasApplication.class, args);
	}

}
