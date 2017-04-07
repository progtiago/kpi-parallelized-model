package br.com.tiago.executor;

public abstract class MetricExecutor implements Executor {

    public void execute() {
        process();
    }

    protected abstract void process();

}
