package br.com.tiago.executor.provider.processC;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

@Service("ReportExecutorProviderC")
public class ReportExecutorProvider extends ReportExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process C.");
    }

}
