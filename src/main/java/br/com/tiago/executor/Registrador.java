package br.com.tiago.executor;

import br.com.tiago.annotation.Processor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Registrador {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${metrics.exchange}")
    private String exchange;

    public void registrar(final Executor executor) {
        registrar(executor, null);
    }

    public void registrar(final Executor executor, final String rountingKey) {
        Processor annotation = executor.getClass().getAnnotation(Processor.class);
        int sequence = annotation.sequence();
        String name = annotation.value();

        sendRedis(sequence, name);
        sendRabbit(name, rountingKey);
    }

    private void sendRedis(int sequence, String processor) {
        System.out.println("Processo agendado: " + processor + " com prioridade: " + sequence);
    }

    private void sendRabbit(String processor, String routingKey) {
        rabbitTemplate.convertAndSend(exchange, routingKey, processor);
    }

}
