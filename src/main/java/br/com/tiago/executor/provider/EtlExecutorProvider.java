package br.com.tiago.executor.provider;

import br.com.tiago.executor.EtlExecutor;
import org.springframework.stereotype.Component;

@Component
public class EtlExecutorProvider implements EtlExecutor {

    @Override
    public void execute() {
        System.out.println("EtlExecutorProvider");
    }
}
