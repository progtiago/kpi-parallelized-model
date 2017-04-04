package br.com.tiago.executor.provider;

import br.com.tiago.executor.ReportExecutor;
import org.springframework.stereotype.Component;

@Component
public class ReportExecutorProvider implements ReportExecutor {

    @Override
    public void execute() {
        System.out.println("ReportExecutorProvider");
    }

}
