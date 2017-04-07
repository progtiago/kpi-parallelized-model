package br.com.tiago.executor.provider.processE;

import br.com.tiago.executor.MetricExecutor;
import org.springframework.stereotype.Service;

@Service("MetricExecutorProviderE")
public class MetricExecutorProvider extends MetricExecutor {

    @Override
    protected void process() {
        System.out.println("MetricExecutorProvider for Process E.");
    }

}
