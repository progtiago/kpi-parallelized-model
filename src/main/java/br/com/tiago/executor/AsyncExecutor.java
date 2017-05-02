package br.com.tiago.executor;

import java.util.List;

import br.com.tiago.cache.StatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.tiago.service.StatusExecutorService;

@Component
@Slf4j
public class AsyncExecutor {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private StatusExecutorService statusExecutorService;

    @Value("${metrics.start.exchange}")
    private String processorExchange;

    public void schedule(final Executor executor) {
        ProcessData processData = new ProcessData(executor);
        sendRedis(processData);
    }

    public void finalize(final Executor executor) {
        ProcessData processData = new ProcessData(executor);
        statusExecutorService.finalize(processData);
        if (statusExecutorService.isSequenceCompleted(processData.getSequence())) {
            start(processData.getSequence() + 1);
        }
    }

    public void start() {
       statusExecutorService.getFirstSequence().forEach(this ::sendProcess);
    }

    public void start(final Integer sequence) {
        List<ProcessData> processes = statusExecutorService.getSequence(sequence);
        if(processes != null && !processes.isEmpty()) {
            processes.forEach(this ::sendProcess);
        }
    }

    private void sendProcess(final ProcessData processData) {
        if(statusExecutorService.isRunning(processData)) {
            log.error("The process was started by other listener.");
        } else {
            statusExecutorService.updateStatus(processData, StatusEnum.RUNNING);
            sendStartMessageToRabbit(processData);
        }

    }

    private void sendRedis(final ProcessData processData) {
        statusExecutorService.register(processData);
    }

    private void sendStartMessageToRabbit(final ProcessData processData) {
        rabbitTemplate.convertAndSend(processorExchange, null, processData.getName());
    }
}
