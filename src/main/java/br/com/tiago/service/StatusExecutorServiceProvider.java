package br.com.tiago.service;

import static br.com.tiago.cache.StatusEnum.SUCESS;
import static java.util.stream.Collectors.toList;
import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import br.com.tiago.cache.StatusEnum;
import br.com.tiago.cache.repository.StatusRepository;
import br.com.tiago.executor.Executor;
import br.com.tiago.executor.ProcessData;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StatusExecutorServiceProvider implements StatusExecutorService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public void register(final ProcessData processData) {
        log.info("Processo agendado: {} - com ordem: {}", processData.getName(), processData.getSequence());
        statusRepository.save(processData);
    }

    @Override
    public void finalize(final ProcessData processData) {
        log.info("Processo encerrado: {} - com ordem: {}", processData.getName(), processData.getSequence());
        statusRepository.save(processData, SUCESS);
    }

    public boolean canExecutePosteriorSequence(final Integer sequence) {
        List<ProcessData> processors = statusRepository.findSequence(sequence);
        List<ProcessData> notCompleted =
                processors.stream().filter(processData -> !statusRepository.isReady(processData)).collect(toList());

        return !isEmpty(notCompleted);
    }

    @Override
    public List<ProcessData> getFirstSequence() {
        Integer firstSequence = statusRepository.getFirstSequence();
        return statusRepository.findSequence(firstSequence);
    }

}
