package br.com.tiago.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static br.com.tiago.config.RabbitMqConfiguration.*;

@Component
@Slf4j
public class MetricsServiceProvider {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void initProcess() {
        initProcessEtl();
        initiProcessMetrics();
        initProcessReports();
    }

    private void initProcessEtl() {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_ETL, "EtlExecutorProviderA");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_ETL, "EtlExecutorProviderB");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_ETL, "EtlExecutorProviderC");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_ETL, "EtlExecutorProviderD");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_ETL, "EtlExecutorProviderE");
    }

    private void initiProcessMetrics() {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_METRIC, "MetricExecutorProviderA");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_METRIC, "MetricExecutorProviderB");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_METRIC, "MetricExecutorProviderC");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_METRIC, "MetricExecutorProviderD");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_METRIC, "MetricExecutorProviderE");
    }

    private void initProcessReports() {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_REPORT, "ReportExecutorProviderA");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_REPORT, "ReportExecutorProviderB");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_REPORT, "ReportExecutorProviderC");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_REPORT, "ReportExecutorProviderD");
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_REPORT, "ReportExecutorProviderE");
    }
}
