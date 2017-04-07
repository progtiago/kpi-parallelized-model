package br.com.tiago.executor.provider.processA;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

@Service("ReportExecutorProviderA")
public class ReportExecutorProvider extends ReportExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process A.");
    }

}
