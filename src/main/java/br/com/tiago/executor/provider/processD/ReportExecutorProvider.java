package br.com.tiago.executor.provider.processD;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Service;

@Service("ReportExecutorProviderD")
public class ReportExecutorProvider implements ReportExecutor {

    @Override
    public void execute() {
        System.out.println("ReportExecutorProvider for Process D.");
    }

}
