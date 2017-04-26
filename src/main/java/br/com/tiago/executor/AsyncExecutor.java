package br.com.tiago.executor;

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

    @Value("${metrics.exchange}")
    private String exchange;

    public void schedule(final Executor executor) {
        ProcessData processData = new ProcessData(executor);
        sendRedis(processData);
    }

    public void finalize(final Executor executor) {
        ProcessData processData = new ProcessData(executor);
        statusExecutorService.finalize(processData);
    }

    public void start() {
       statusExecutorService.getFirstSequence().forEach(this :: sendRabbit);
    }

    private void sendRedis(final ProcessData processData) {
        statusExecutorService.register(processData);
    }

    private void sendRabbit(final ProcessData processData) {
        rabbitTemplate.convertAndSend(exchange, null, processData.getName());
    }

}
