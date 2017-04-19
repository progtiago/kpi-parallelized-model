package br.com.tiago.executor.provider.processA;

import br.com.tiago.executor.MetricExecutor;
import br.com.tiago.executor.ProcessConstants;
import org.springframework.stereotype.Service;

import static br.com.tiago.executor.ProcessConstants.METRIC_EXECUTOR_PROVIDER_A;

@Service(METRIC_EXECUTOR_PROVIDER_A)
public class MetricExecutorProvider extends MetricExecutor {

    @Override
    protected void process() {
        System.out.println("MetricExecutorProvider for Process A.");
    }

}
