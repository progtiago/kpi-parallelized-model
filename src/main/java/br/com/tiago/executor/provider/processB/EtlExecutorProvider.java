package br.com.tiago.executor.provider.processB;

import br.com.tiago.executor.EtlExecutor;
import org.springframework.stereotype.Service;

import static br.com.tiago.executor.ProcessConstants.ETL_EXECUTOR_PROVIDER_B;

@Service(ETL_EXECUTOR_PROVIDER_B)
public class EtlExecutorProvider extends EtlExecutor {

    @Override
    protected void process() {
        System.out.println("EtlExecutorProvider for Process B.");
    }
}
