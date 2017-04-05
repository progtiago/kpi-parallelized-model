package br.com.tiago.executor.provider.processA;

import br.com.tiago.executor.EtlExecutor;
import org.springframework.stereotype.Service;

@Service("EtlExecutorProviderA")
public class EtlExecutorProvider implements EtlExecutor {

    @Override
    public void execute() {
        System.out.println("EtlExecutorProvider for Process A.");
    }
}
