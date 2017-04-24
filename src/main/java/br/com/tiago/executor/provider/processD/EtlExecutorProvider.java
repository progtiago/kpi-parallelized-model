package br.com.tiago.executor.provider.processD;

import static br.com.tiago.executor.ProcessConstants.ETL_EXECUTOR_PROVIDER_D;

import br.com.tiago.annotation.Processor;
import br.com.tiago.executor.EtlExecutor;

@Processor(sequence = 0, value = ETL_EXECUTOR_PROVIDER_D)
public class EtlExecutorProvider extends EtlExecutor {

    @Override
    protected void process() {
        System.out.println("EtlExecutorProvider for Process D.");
    }
}
