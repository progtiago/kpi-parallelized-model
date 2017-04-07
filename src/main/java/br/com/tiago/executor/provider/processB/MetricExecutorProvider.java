package br.com.tiago.executor.provider.processB;

import br.com.tiago.executor.MetricExecutor;
import org.springframework.stereotype.Service;

@Service("MetricExecutorProviderB")
public class MetricExecutorProvider extends MetricExecutor {

    @Override
    protected void process() {
        System.out.println("MetricExecutorProvider for Process B.");
    }

}
