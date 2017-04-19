package br.com.tiago.executor.provider.processD;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

import static br.com.tiago.executor.ProcessConstants.REPORT_EXECUTOR_PROVIDER_D;

@Service(REPORT_EXECUTOR_PROVIDER_D)
public class ReportExecutorProvider extends ReportExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process D.");
    }

}
