package br.com.tiago.executor.provider.processC;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

import static br.com.tiago.executor.ProcessConstants.REPORT_EXECUTOR_PROVIDER_A;
import static br.com.tiago.executor.ProcessConstants.REPORT_EXECUTOR_PROVIDER_C;

@Service(REPORT_EXECUTOR_PROVIDER_C)
public class ReportExecutorProvider extends ReportExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process C.");
    }

}
