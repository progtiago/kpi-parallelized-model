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
    public final static String ETL_QUEUE_NAME = "etl-queue";
    public final static String METRIC_QUEUE_NAME = "metric-queue";
    public final static String REPORT_QUEUE_NAME = "report-queue";
    public final static String ROUTING_KEY_ETL = "event.etl";
    public final static String ROUTING_KEY_METRIC = "event.metric";
    public final static String ROUTING_KEY_REPORT = "event.report";

    @Bean
    Queue etlQueue() {
        return new Queue(ETL_QUEUE_NAME, false);
    }

    @Bean
    Queue metricQueue() {
        return new Queue(METRIC_QUEUE_NAME, false);
    }

    @Bean
    Queue reportQueue() {
        return new Queue(REPORT_QUEUE_NAME, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding bindingEtlQueue(Queue metricQueue, TopicExchange exchange) {
        return BindingBuilder.bind(metricQueue).to(exchange).with(ROUTING_KEY_ETL);
    }

    @Bean
    Binding bindingMetricQueue(Queue metricQueue, TopicExchange exchange) {
        return BindingBuilder.bind(metricQueue).to(exchange).with(ROUTING_KEY_METRIC);
    }

    @Bean
    Binding bindingReportQueue(Queue reportQueue, TopicExchange exchange) {
        return BindingBuilder.bind(reportQueue).to(exchange).with(ROUTING_KEY_REPORT);
    }
}
