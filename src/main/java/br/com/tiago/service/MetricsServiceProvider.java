package br.com.tiago.service;

import br.com.tiago.ApplicationContextProvider;
import br.com.tiago.executor.EtlExecutor;
import br.com.tiago.executor.Executor;
import br.com.tiago.executor.MetricExecutor;
import br.com.tiago.executor.ReportExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MetricsServiceProvider {

    @Autowired
    private List<EtlExecutor> etlExecutors;

    @Autowired
    private List<MetricExecutor> metricExecutors;

    @Autowired
    private List<ReportExecutor> reportExecutors;

    @Autowired
    private ApplicationContextProvider applicationContextProvider;

    public void process() {
        etlExecutors.forEach(EtlExecutor::execute);
        metricExecutors.forEach(MetricExecutor::execute);
        reportExecutors.forEach(ReportExecutor::execute);
    }

    public void processQueueLike() {
        ApplicationContext context = applicationContextProvider.getApplicationContext();
        Executor etlExecutorProviderA = (Executor) context.getBean("EtlExecutorProviderA");
        Executor etlExecutorProviderB = (Executor) context.getBean("EtlExecutorProviderB");
        Executor etlExecutorProviderC = (Executor) context.getBean("EtlExecutorProviderC");
        Executor etlExecutorProviderD = (Executor) context.getBean("EtlExecutorProviderD");
        Executor etlExecutorProviderE = (Executor) context.getBean("EtlExecutorProviderE");

        etlExecutorProviderA.execute();
        etlExecutorProviderB.execute();
        etlExecutorProviderC.execute();
        etlExecutorProviderD.execute();
        etlExecutorProviderE.execute();
    }

}
