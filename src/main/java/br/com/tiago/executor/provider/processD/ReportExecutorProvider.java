package br.com.tiago.executor.provider.processD;

import static br.com.tiago.executor.ProcessConstants.REPORT_EXECUTOR_PROVIDER_D;

import br.com.tiago.annotation.Processor;
import br.com.tiago.executor.AbstractExecutor;

@Processor(sequence = 2, value = REPORT_EXECUTOR_PROVIDER_D)
public class ReportExecutorProvider extends AbstractExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process D.");
    }

}
