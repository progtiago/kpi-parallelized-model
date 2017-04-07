package br.com.tiago.executor.provider.processD;

import br.com.tiago.executor.MetricExecutor;
import org.springframework.stereotype.Service;

@Service("MetricExecutorProviderD")
public class MetricExecutorProvider extends MetricExecutor {

    @Override
    protected void process() {
        System.out.println("MetricExecutorProvider for Process D.");
    }

}
