package br.com.tiago.executor.provider.processA;

import br.com.tiago.executor.EtlExecutor;
import org.springframework.stereotype.Service;

@Service("EtlExecutorProviderA")
public class EtlExecutorProvider extends EtlExecutor {

    @Override
    protected void process() {
        System.out.println("EtlExecutorProvider for Process A.");
    }
}
