package br.com.tiago.executor.provider.processC;

import br.com.tiago.executor.MetricExecutor;
import org.springframework.stereotype.Service;

import static br.com.tiago.executor.ProcessConstants.METRIC_EXECUTOR_PROVIDER_A;
import static br.com.tiago.executor.ProcessConstants.METRIC_EXECUTOR_PROVIDER_C;

@Service(METRIC_EXECUTOR_PROVIDER_C)
public class MetricExecutorProvider extends MetricExecutor {

    @Override
    protected void process() {
        System.out.println("MetricExecutorProvider for Process C.");
    }

}
