package br.com.tiago.executor.provider.processD;

import br.com.tiago.executor.EtlExecutor;
import org.springframework.stereotype.Service;

import static br.com.tiago.executor.ProcessConstants.ETL_EXECUTOR_PROVIDER_D;

@Service(ETL_EXECUTOR_PROVIDER_D)
public class EtlExecutorProvider extends EtlExecutor {

    @Override
    protected void process() {
        System.out.println("EtlExecutorProvider for Process D.");
    }
}
