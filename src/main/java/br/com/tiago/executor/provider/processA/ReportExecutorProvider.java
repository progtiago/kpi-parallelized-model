package br.com.tiago.executor.provider.processA;

import br.com.tiago.executor.ProcessConstants;
import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

import static br.com.tiago.executor.ProcessConstants.REPORT_EXECUTOR_PROVIDER_A;

@Service(REPORT_EXECUTOR_PROVIDER_A)
public class ReportExecutorProvider extends ReportExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process A.");
    }

}
