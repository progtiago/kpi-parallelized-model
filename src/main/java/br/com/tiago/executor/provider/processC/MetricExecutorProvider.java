package br.com.tiago.executor.provider.processC;

import br.com.tiago.executor.MetricExecutor;
import org.springframework.stereotype.Service;

@Service("MetricExecutorProviderC")
public class MetricExecutorProvider implements MetricExecutor {

    @Override
    public void execute() {
        System.out.println("MetricExecutorProvider for Process C.");
    }

}
