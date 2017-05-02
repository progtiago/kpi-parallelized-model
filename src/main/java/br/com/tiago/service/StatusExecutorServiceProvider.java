package br.com.tiago.service;

import br.com.tiago.cache.StatusEnum;
import br.com.tiago.cache.repository.StatusRepository;
import br.com.tiago.executor.ProcessData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.tiago.cache.StatusEnum.SUCESS;
import static java.util.stream.Collectors.toList;
import static org.springframework.util.CollectionUtils.isEmpty;

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

    @Override
    public boolean isSequenceCompleted(final Integer sequence) {
        List<ProcessData> processors = statusRepository.findSequence(sequence);
        List<ProcessData> notCompleted =
                processors.stream().filter(
                        processData -> !isReady(processData)).collect(toList());

        return isEmpty(notCompleted);
    }

    @Override
    public boolean isReady(final ProcessData processData) {
        return StatusEnum.SUCESS.equals(statusRepository.getStatus(processData));
    }

    @Override
    public boolean isRunning(final ProcessData processData) {
        return StatusEnum.RUNNING.equals(statusRepository.getStatus(processData));
    }

    @Override
    public void updateStatus(final ProcessData processData, final StatusEnum statusEnum) {
        statusRepository.save(processData, statusEnum);
    }

    @Override
    public List<ProcessData> getFirstSequence() {
        Integer firstSequence = statusRepository.getFirstSequence();
        return statusRepository.findSequence(firstSequence);
    }

    @Override
    public List<ProcessData> getPreviousSequence(final Integer sequence) {
        return statusRepository.findSequence(sequence - 1);
    }

    @Override
    public List<ProcessData> getPosteriorSequence(final Integer sequence) {
        return statusRepository.findSequence(sequence + 1);
    }

    @Override
    public List<ProcessData> getSequence(final Integer sequence) {
        return statusRepository.findSequence(sequence);
    }

}
