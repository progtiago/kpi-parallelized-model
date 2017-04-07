package br.com.tiago.executor.provider.processE;

import br.com.tiago.executor.EtlExecutor;
import org.springframework.stereotype.Service;

@Service("EtlExecutorProviderE")
public class EtlExecutorProvider extends EtlExecutor {

    @Override
    protected void process() {
        System.out.println("EtlExecutorProvider for Process E.");
    }
}
