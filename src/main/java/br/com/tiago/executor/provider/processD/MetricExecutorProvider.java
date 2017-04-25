package br.com.tiago.executor.provider.processD;

import static br.com.tiago.executor.ProcessConstants.METRIC_EXECUTOR_PROVIDER_D;

import br.com.tiago.annotation.Processor;
import br.com.tiago.executor.AbstractExecutor;

@Processor(sequence = 1, value = METRIC_EXECUTOR_PROVIDER_D)
public class MetricExecutorProvider extends AbstractExecutor {

    @Override
    protected void process() {
        System.out.println("MetricExecutorProvider for Process D.");
    }

}
