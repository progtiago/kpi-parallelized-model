package br.com.tiago.executor;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.tiago.service.StatusExecutorService;

@Component
public class AsyncExecutor {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private StatusExecutorService statusExecutorService;

    @Value("${metrics.start.exchange}")
    private String processorExchange;

    @Value("${metrics.finalize.exchange}")
    private String completedExchange;

    public void schedule(final Executor executor) {
        ProcessData processData = new ProcessData(executor);
        sendRedis(processData);
    }

    public void finalize(final Executor executor) {
        ProcessData processData = new ProcessData(executor);
        sendFinalizeMessageToRabbit(processData);
    }

    public void start() {
       statusExecutorService.getFirstSequence().forEach(this ::sendStartMessageToRabbit);
    }

    public void start(final Integer sequence) {
        List<ProcessData> processes = statusExecutorService.getSequence(sequence);
        if(processes != null && !processes.isEmpty()) {
            processes.forEach(this ::sendStartMessageToRabbit);
        }
    }

    private void sendRedis(final ProcessData processData) {
        statusExecutorService.register(processData);
    }

    private void sendStartMessageToRabbit(final ProcessData processData) {
        rabbitTemplate.convertAndSend(processorExchange, null, processData.getName());
    }

    private void sendFinalizeMessageToRabbit(final ProcessData processData) {
        rabbitTemplate.convertAndSend(completedExchange, null, processData);
    }
}
