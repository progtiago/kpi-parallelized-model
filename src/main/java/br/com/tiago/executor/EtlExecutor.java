package br.com.tiago.executor;

public abstract class EtlExecutor implements Executor{

    public void execute() {
        process();
    }

    protected abstract void process();

}
