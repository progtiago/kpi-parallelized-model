package br.com.tiago.executor.provider.processA;

import static br.com.tiago.executor.ProcessConstants.METRIC_EXECUTOR_PROVIDER_A;

import br.com.tiago.annotation.Processor;
import br.com.tiago.executor.AbstractExecutor;

@Processor(sequence = 1, value = METRIC_EXECUTOR_PROVIDER_A)
public class MetricExecutorProvider extends AbstractExecutor {

    @Override
    protected void process() {
        System.out.println("MetricExecutorProvider for Process A.");
    }
}
