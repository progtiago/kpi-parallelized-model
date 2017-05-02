package br.com.tiago.executor.provider.processA;

import static br.com.tiago.executor.ProcessConstants.ETL_EXECUTOR_PROVIDER_A;

import br.com.tiago.annotation.Processor;
import br.com.tiago.executor.AbstractExecutor;

@Processor(sequence = 0, value = ETL_EXECUTOR_PROVIDER_A)
public class EtlExecutorProvider extends AbstractExecutor {

    @Override
    protected void process() {
        System.out.println("EtlExecutorProvider for Process A.");
    }
}
