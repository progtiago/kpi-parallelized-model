package br.com.tiago.executor.provider.processB;

import static br.com.tiago.executor.ProcessConstants.ETL_EXECUTOR_PROVIDER_B;

import br.com.tiago.annotation.Processor;
import br.com.tiago.executor.AbstractExecutor;

@Processor(sequence = 0, value = ETL_EXECUTOR_PROVIDER_B)
public class EtlExecutorProvider extends AbstractExecutor {

    @Override
    protected void process() {
        System.out.println("EtlExecutorProvider for Process B.");
    }
}
