package br.com.tiago.executor.provider.processA;

import static br.com.tiago.executor.ProcessConstants.ETL_EXECUTOR_PROVIDER_A;

import br.com.tiago.annotation.Processor;
import br.com.tiago.config.RabbitMqConfiguration;
import br.com.tiago.executor.EtlExecutor;

@Processor(sequence = 0, value = ETL_EXECUTOR_PROVIDER_A)
public class EtlExecutorProvider extends EtlExecutor {

    @Override
    protected void process() {
        System.out.println("EtlExecutorProvider for Process A.");
    }
}
