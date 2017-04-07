package br.com.tiago.executor.provider.processE;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

@Service("ReportExecutorProviderE")
public class ReportExecutorProvider extends ReportExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process E.");
    }

}
