package br.com.tiago.executor.provider.processA;

import br.com.tiago.executor.MetricExecutor;
import org.springframework.stereotype.Service;

@Service("MetricExecutorProviderA")
public class MetricExecutorProvider implements MetricExecutor {

    @Override
    public void execute() {
        System.out.println("MetricExecutorProvider for Process A.");
    }

}
