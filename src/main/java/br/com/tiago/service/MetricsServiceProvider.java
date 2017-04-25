package br.com.tiago.service;

import br.com.tiago.executor.EtlExecutor;
import br.com.tiago.executor.Executor;
import br.com.tiago.executor.MetricExecutor;
import br.com.tiago.executor.ReportExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static br.com.tiago.config.RabbitMqConfiguration.*;
import static br.com.tiago.executor.ProcessConstants.*;

@Component
@Slf4j
public class MetricsServiceProvider {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private List<Executor> executors;

    public void initProcess() {
        executors.forEach(Executor::register);
    }
}
