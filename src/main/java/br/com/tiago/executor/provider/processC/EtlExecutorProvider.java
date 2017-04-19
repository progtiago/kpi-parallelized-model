package br.com.tiago.executor.provider.processC;

import br.com.tiago.executor.EtlExecutor;
import org.springframework.stereotype.Service;

import static br.com.tiago.executor.ProcessConstants.ETL_EXECUTOR_PROVIDER_C;

@Service(ETL_EXECUTOR_PROVIDER_C)
public class EtlExecutorProvider extends EtlExecutor {

    @Override
    protected void process() {
        System.out.println("EtlExecutorProvider for Process C.");
    }
}
