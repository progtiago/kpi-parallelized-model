package br.com.tiago.executor.provider.processD;

import br.com.tiago.executor.EtlExecutor;
import org.springframework.stereotype.Service;

@Service("EtlExecutorProviderD")
public class EtlExecutorProvider extends EtlExecutor {

    @Override
    protected void process() {
        System.out.println("EtlExecutorProvider for Process D.");
    }
}
