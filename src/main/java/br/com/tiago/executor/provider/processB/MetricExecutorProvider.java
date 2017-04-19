package br.com.tiago.executor.provider.processB;

import br.com.tiago.executor.MetricExecutor;
import org.springframework.stereotype.Service;

import static br.com.tiago.executor.ProcessConstants.METRIC_EXECUTOR_PROVIDER_A;
import static br.com.tiago.executor.ProcessConstants.METRIC_EXECUTOR_PROVIDER_B;

@Service(METRIC_EXECUTOR_PROVIDER_B)
public class MetricExecutorProvider extends MetricExecutor {

    @Override
    protected void process() {
        System.out.println("MetricExecutorProvider for Process B.");
    }

}
