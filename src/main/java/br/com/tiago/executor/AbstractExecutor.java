package br.com.tiago.executor;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tiago.service.StatusExecutorService;

public abstract class AbstractExecutor implements Executor {

    @Autowired
    private AsyncExecutor asyncExecutor;

    @Override
    public final void finalize() {
        asyncExecutor.finalize(this);
    }

    public final void execute() {
        process();
        finalize();
    }

    protected abstract void process();

}
