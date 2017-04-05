package br.com.tiago.executor.provider.processB;

import br.com.tiago.executor.EtlExecutor;
import org.springframework.stereotype.Service;

@Service("EtlExecutorProviderB")
public class EtlExecutorProvider implements EtlExecutor {

    @Override
    public void execute() {
        System.out.println("EtlExecutorProvider for Process B.");
    }
}
