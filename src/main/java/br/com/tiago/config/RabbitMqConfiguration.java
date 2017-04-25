package br.com.tiago.config;

import br.com.tiago.Application;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {Application.class})
@EnableConfigurationProperties({RabbitProperties.class})
public class RabbitMqConfiguration {

    public final static String EXCHANGE_NAME = "processor-exchange";
    public final static String EXECUTOR_QUEUE_NAME = "executor-queue";

    @Bean
    Queue executorQueue() {
        return new Queue(EXECUTOR_QUEUE_NAME, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding bindingExecutorQueue(Queue metricQueue, TopicExchange exchange) {
        return BindingBuilder.bind(metricQueue).to(exchange).with("*");
    }

}
