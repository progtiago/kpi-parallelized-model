package br.com.tiago.executor;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tiago.service.StatusExecutorService;

public abstract class AbstractExecutor implements Executor {

    @Autowired
    private AsyncExecutor asyncExecutor;

    @Autowired
    private StatusExecutorService statusExecutorService;

    @Override
    public void finalize() {
    }

    public void execute() {
        process();
    }

    protected abstract void process();

}
