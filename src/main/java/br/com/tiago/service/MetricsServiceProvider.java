package br.com.tiago.service;

import br.com.tiago.executor.AsyncExecutor;
import br.com.tiago.executor.Executor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class MetricsServiceProvider {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private List<Executor> executors;

    @Autowired
    private AsyncExecutor asyncExecutor;

    public void initProcess() {
        executors.forEach(executor -> asyncExecutor.schedule(executor));
        asyncExecutor.start();
    }
}
