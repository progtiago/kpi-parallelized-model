package br.com.tiago.config;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.tiago.KpiModelApplication;

@Configuration
@ComponentScan(basePackageClasses = {KpiModelApplication.class})
@EnableConfigurationProperties({RabbitProperties.class})
public class RabbitMqConfiguration {
}
