package br.com.tiago.executor;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tiago.service.StatusExecutorService;

public abstract class AbstractExecutor implements Executor {

    @Autowired
    private AsyncExecutor asyncExecutor;

    @Override
    public void finalize() {
        asyncExecutor.finalize(this);
    }

    public void execute() {
        process();
        finalize();
    }

    protected abstract void process();

}
