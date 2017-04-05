package br.com.tiago.executor.provider.processC;

import br.com.tiago.executor.EtlExecutor;
import org.springframework.stereotype.Service;

@Service("EtlExecutorProviderC")
public class EtlExecutorProvider implements EtlExecutor {

    @Override
    public void execute() {
        System.out.println("EtlExecutorProvider for Process C.");
    }
}
