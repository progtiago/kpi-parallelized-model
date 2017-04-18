package br.com.tiago;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import br.com.tiago.config.RabbitMqConfiguration;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(RabbitMqConfiguration.class).run(args);
	}
}
