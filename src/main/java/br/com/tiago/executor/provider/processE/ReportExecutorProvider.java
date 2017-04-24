package br.com.tiago.executor.provider.processE;

import static br.com.tiago.executor.ProcessConstants.REPORT_EXECUTOR_PROVIDER_E;

import br.com.tiago.annotation.Processor;
import br.com.tiago.executor.ReportExecutor;

@Processor(sequence = 0, value = REPORT_EXECUTOR_PROVIDER_E)
public class ReportExecutorProvider extends ReportExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process E.");
    }

}
