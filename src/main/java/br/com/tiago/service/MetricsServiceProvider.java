package br.com.tiago.service;

import br.com.tiago.executor.EtlExecutor;
import br.com.tiago.executor.MetricExecutor;
import br.com.tiago.executor.ReportExecutor;
import org.springframework.beans.factory.annotation.Autowired;
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

    public void process() {
        etlExecutors.forEach(EtlExecutor::execute);
        metricExecutors.forEach(MetricExecutor::execute);
        reportExecutors.forEach(ReportExecutor::execute);
    }

}
