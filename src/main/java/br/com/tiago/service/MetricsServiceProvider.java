package br.com.tiago.service;

import br.com.tiago.executor.ProcessConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static br.com.tiago.config.RabbitMqConfiguration.*;
import static br.com.tiago.executor.ProcessConstants.*;

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
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_ETL, ETL_EXECUTOR_PROVIDER_A);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_ETL, ETL_EXECUTOR_PROVIDER_B);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_ETL, ETL_EXECUTOR_PROVIDER_C);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_ETL, ETL_EXECUTOR_PROVIDER_D);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_ETL, ETL_EXECUTOR_PROVIDER_E);
    }

    private void initiProcessMetrics() {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_METRIC, METRIC_EXECUTOR_PROVIDER_A);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_METRIC, METRIC_EXECUTOR_PROVIDER_B);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_METRIC, METRIC_EXECUTOR_PROVIDER_C);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_METRIC, METRIC_EXECUTOR_PROVIDER_D);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_METRIC, METRIC_EXECUTOR_PROVIDER_E);
    }

    private void initProcessReports() {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_REPORT, REPORT_EXECUTOR_PROVIDER_A);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_REPORT, REPORT_EXECUTOR_PROVIDER_B);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_REPORT, REPORT_EXECUTOR_PROVIDER_C);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_REPORT, REPORT_EXECUTOR_PROVIDER_D);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_REPORT, REPORT_EXECUTOR_PROVIDER_E);
    }
}
