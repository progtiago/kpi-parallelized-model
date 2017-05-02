package br.com.tiago.executor.provider.processE;

import static br.com.tiago.executor.ProcessConstants.ETL_EXECUTOR_PROVIDER_E;

import br.com.tiago.annotation.Processor;
import br.com.tiago.executor.AbstractExecutor;

@Processor(sequence = 0, value = ETL_EXECUTOR_PROVIDER_E)
public class EtlExecutorProvider extends AbstractExecutor {

    @Override
    protected void process() {
        System.out.println("EtlExecutorProvider for Process E.");
    }
}
