package br.com.tiago.executor.provider.processA;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

@Service("ReportExecutorProviderA")
public class ReportExecutorProvider implements ReportExecutor {

    @Override
    public void execute() {
        System.out.println("ReportExecutorProvider for Process A.");
    }

}
