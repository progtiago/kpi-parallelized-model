package br.com.tiago.executor.provider.processC;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

@Service("ReportExecutorProviderC")
public class ReportExecutorProvider implements ReportExecutor {

    @Override
    public void execute() {
        System.out.println("ReportExecutorProvider for Process C.");
    }

}
