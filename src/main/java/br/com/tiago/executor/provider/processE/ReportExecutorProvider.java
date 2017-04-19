package br.com.tiago.executor.provider.processE;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

import static br.com.tiago.executor.ProcessConstants.REPORT_EXECUTOR_PROVIDER_E;

@Service(REPORT_EXECUTOR_PROVIDER_E)
public class ReportExecutorProvider extends ReportExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process E.");
    }

}
