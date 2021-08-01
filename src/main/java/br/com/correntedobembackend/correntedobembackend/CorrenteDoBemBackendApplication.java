package br.com.correntedobembackend.correntedobembackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CorrenteDoBemBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorrenteDoBemBackendApplication.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEnconder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
