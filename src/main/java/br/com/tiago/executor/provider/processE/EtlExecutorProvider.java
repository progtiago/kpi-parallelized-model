package br.com.tiago.executor.provider.processE;

import br.com.tiago.executor.EtlExecutor;
import org.springframework.stereotype.Service;

@Service("EtlExecutorProviderE")
public class EtlExecutorProvider implements EtlExecutor {

    @Override
    public void execute() {
        System.out.println("EtlExecutorProvider for Process E.");
    }
}
