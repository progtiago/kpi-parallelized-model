package br.com.tiago.executor.provider.processA;

import br.com.tiago.executor.MetricExecutor;
import org.springframework.stereotype.Service;

@Service("MetricExecutorProviderA")
public class MetricExecutorProvider extends MetricExecutor {

    @Override
    protected void process() {
        System.out.println("MetricExecutorProvider for Process A.");
    }

}
