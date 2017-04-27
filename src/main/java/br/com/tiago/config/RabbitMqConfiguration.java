package br.com.tiago.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.tiago.Application;

@Configuration
@ComponentScan(basePackageClasses = {Application.class})
@EnableConfigurationProperties({RabbitProperties.class})
public class RabbitMqConfiguration {

    public final static String PROCESSOR_EXCHANGE_NAME = "processor-exchange";
    public final static String COMPLETED_EXCHANGE_NAME = "completed-exchange";
    public final static String EXECUTOR_QUEUE_NAME = "executor-queue";
    public final static String COMPLETED_EXECUTOR_QUEUE_NAME = "completed-executor-queue";

    @Bean
    TopicExchange processorExchange() {
        return new TopicExchange(PROCESSOR_EXCHANGE_NAME);
    }

    @Bean
    TopicExchange completedExchange() {
        return new TopicExchange(COMPLETED_EXCHANGE_NAME);
    }

    @Bean
    Queue executorQueue() {
        return new Queue(EXECUTOR_QUEUE_NAME, false);
    }

    @Bean
    Queue completedQueue() {
        return new Queue(COMPLETED_EXECUTOR_QUEUE_NAME, false, true, false);
    }

    @Bean
    Binding bindingExecutorQueue(Queue executorQueue, TopicExchange processorExchange) {
        return BindingBuilder.bind(executorQueue).to(processorExchange).with("");
    }

    @Bean
    Binding bindingCompletedQueue(Queue completedQueue, TopicExchange completedExchange) {
        return BindingBuilder.bind(completedQueue).to(completedExchange).with("");
    }

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

}
