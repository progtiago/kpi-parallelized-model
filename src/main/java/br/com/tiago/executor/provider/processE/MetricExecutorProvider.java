package br.com.tiago.executor.provider.processE;

import br.com.tiago.executor.MetricExecutor;
import org.springframework.stereotype.Service;

@Service("MetricExecutorProviderE")
public class MetricExecutorProvider implements MetricExecutor {

    @Override
    public void execute() {
        System.out.println("MetricExecutorProvider for Process E.");
    }

}
