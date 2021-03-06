package br.com.tiago.executor.provider.processC;

import static br.com.tiago.executor.ProcessConstants.REPORT_EXECUTOR_PROVIDER_C;

import br.com.tiago.annotation.Processor;
import br.com.tiago.executor.AbstractExecutor;

@Processor(sequence = 2, value = REPORT_EXECUTOR_PROVIDER_C)
public class ReportExecutorProvider extends AbstractExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process C.");
    }

}
