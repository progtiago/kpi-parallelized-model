package br.com.tiago.listener;

import static br.com.tiago.config.RabbitMqConfiguration.COMPLETED_EXECUTOR_QUEUE_NAME;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.tiago.executor.AsyncExecutor;
import br.com.tiago.executor.ProcessData;
import br.com.tiago.service.StatusExecutorService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RabbitListener(queues = COMPLETED_EXECUTOR_QUEUE_NAME)
public class FinalizeListener {

    @Autowired
    private StatusExecutorService statusExecutorService;

    @Autowired
    private AsyncExecutor asyncExecutor;

    @RabbitHandler
    public void listen(@Payload ProcessData processData) {
        log.debug("Mensagem recebida: {}", processData);
        int sequence = processData.getSequence();
        statusExecutorService.finalize(processData);
        if (statusExecutorService.canExecutePosteriorSequence(processData.getSequence())) {
            System.out.println("------------------------PODE");
            asyncExecutor.start(++sequence);
        }
    }

}
