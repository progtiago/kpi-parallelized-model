package br.com.tiago.executor;

public abstract class ReportExecutor implements Executor {

    public void execute() {
        process();
    }

    protected abstract void process();

}
