package br.com.tiago.executor;

import org.springframework.beans.factory.annotation.Autowired;

import static br.com.tiago.config.RabbitMqConfiguration.ROUTING_KEY_METRIC;

public abstract class ReportExecutor implements Executor {

    @Autowired
    private Registrador registrador;

    public void register() {
        registrador.registrar(this, ROUTING_KEY_METRIC);
    }

    public void execute() {
        process();
    }

    protected abstract void process();

}
