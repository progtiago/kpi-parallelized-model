package br.com.tiago.executor.provider.processB;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

import static br.com.tiago.executor.ProcessConstants.REPORT_EXECUTOR_PROVIDER_B;

@Service(REPORT_EXECUTOR_PROVIDER_B)
public class ReportExecutorProvider extends ReportExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process B.");
    }

}
