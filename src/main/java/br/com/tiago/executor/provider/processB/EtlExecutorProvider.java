package br.com.tiago.executor.provider.processB;

import br.com.tiago.executor.EtlExecutor;
import org.springframework.stereotype.Service;

@Service("EtlExecutorProviderB")
public class EtlExecutorProvider extends EtlExecutor {

    @Override
    protected void process() {
        System.out.println("EtlExecutorProvider for Process B.");
    }
}
