package br.com.tiago.executor.provider.processA;

import static br.com.tiago.executor.ProcessConstants.REPORT_EXECUTOR_PROVIDER_A;

import br.com.tiago.annotation.Processor;
import br.com.tiago.executor.ReportExecutor;

@Processor(sequence = 2, value = REPORT_EXECUTOR_PROVIDER_A)
public class ReportExecutorProvider extends ReportExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process A.");
    }

}
