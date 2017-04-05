package br.com.tiago.executor.provider.processE;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

@Service("ReportExecutorProviderE")
public class ReportExecutorProvider implements ReportExecutor {

    @Override
    public void execute() {
        System.out.println("ReportExecutorProvider for Process E.");
    }

}
