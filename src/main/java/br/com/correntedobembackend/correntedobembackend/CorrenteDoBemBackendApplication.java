package br.com.correntedobembackend.correntedobembackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CorrenteDoBemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrenteDoBemBackendApplication.class, args);
	}

}
