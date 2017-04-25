package br.com.tiago.executor.provider.processB;

import static br.com.tiago.executor.ProcessConstants.METRIC_EXECUTOR_PROVIDER_B;

import br.com.tiago.annotation.Processor;
import br.com.tiago.executor.AbstractExecutor;

@Processor(sequence = 1, value = METRIC_EXECUTOR_PROVIDER_B)
public class MetricExecutorProvider extends AbstractExecutor {

    @Override
    protected void process() {
        System.out.println("MetricExecutorProvider for Process B.");
    }

}
