package br.com.tiago.api;

import br.com.tiago.service.MetricsServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/metrics")
public class RestClient {

    @Autowired
    private MetricsServiceProvider metricsServiceProvider;

    @RequestMapping(method = RequestMethod.POST)
    public void generate() {
        metricsServiceProvider.processQueueLike();
    }


}
