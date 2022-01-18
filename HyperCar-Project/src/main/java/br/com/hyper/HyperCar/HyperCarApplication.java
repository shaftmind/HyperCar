package br.com.hyper.HyperCar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaAuditing
@Configuration
public class HyperCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyperCarApplication.class, args);
	}

}
