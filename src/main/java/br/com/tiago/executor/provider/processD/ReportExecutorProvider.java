package br.com.tiago.executor.provider.processD;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

@Service("ReportExecutorProviderD")
public class ReportExecutorProvider extends ReportExecutor {

    @Override
    protected void process() {
        System.out.println("ReportExecutorProvider for Process D.");
    }

}
