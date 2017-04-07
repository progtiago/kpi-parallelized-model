package br.com.tiago.executor.provider.processB;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

@Service("ReportExecutorProviderB")
public class ReportExecutorProvider extends ReportExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process B.");
    }

}
