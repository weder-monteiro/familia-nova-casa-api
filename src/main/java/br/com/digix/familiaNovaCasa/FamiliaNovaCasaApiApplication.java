package br.com.digix.familiaNovaCasa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class FamiliaNovaCasaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamiliaNovaCasaApiApplication.class, args);
	}

}
