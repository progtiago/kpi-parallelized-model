package br.com.tiago.listener;

import br.com.tiago.config.ApplicationContextProvider;
import br.com.tiago.executor.Executor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static br.com.tiago.config.RabbitMqConfiguration.EXECUTOR_QUEUE_NAME;

@Slf4j
@Component
@RabbitListener(queues = EXECUTOR_QUEUE_NAME)
public class ProcessListener {

    @Autowired
    private ApplicationContextProvider applicationContextProvider;

    @RabbitHandler
    public void listen(@Payload String message) {
        log.debug("Mensagem recebida: {}", message);

        ApplicationContext context = applicationContextProvider.getApplicationContext();
        Executor executor = (Executor) context.getBean(message);
        executor.execute();
    }

}
