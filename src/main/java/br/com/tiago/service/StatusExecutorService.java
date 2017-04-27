package br.com.tiago.service;

import java.util.List;

import br.com.tiago.executor.ProcessData;

public interface StatusExecutorService {

    void register(ProcessData processData);

    void finalize(ProcessData processData);

    boolean canExecutePosteriorSequence(Integer sequence);

    List<ProcessData> getFirstSequence();

    List<ProcessData> getSequence(final Integer sequence);

    List<ProcessData> getPreviousSequence(final Integer sequence);

    List<ProcessData> getPosteriorSequence(final Integer sequence);

}
