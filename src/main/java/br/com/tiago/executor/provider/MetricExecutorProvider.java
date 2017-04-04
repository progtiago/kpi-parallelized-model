package br.com.tiago.executor.provider;

import br.com.tiago.executor.MetricExecutor;
import org.springframework.stereotype.Component;

@Component
public class MetricExecutorProvider implements MetricExecutor {

    @Override
    public void execute() {
        System.out.println("MetricExecutorProvider");
    }

}
