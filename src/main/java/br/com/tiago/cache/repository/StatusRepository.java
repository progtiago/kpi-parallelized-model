package br.com.tiago.cache.repository;

import static br.com.tiago.cache.StatusEnum.SUCESS;
import static br.com.tiago.cache.StatusEnum.WAIT;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import br.com.tiago.cache.StatusEnum;
import br.com.tiago.executor.ProcessData;

@Repository
public class StatusRepository {

    private static final String ALL = "*";
    private static final String KEY_NAME = "kpi:processor:%s:sequence:%d:name";
    private static final String KEY_STATUS = "kpi:processor:%s:sequence:%d:status";
    private static final String KEY_FIRST_SEQUENCE = "kpi:processor:first";

    @Autowired
    private RedisTemplate<String, String> template;
    private ValueOperations valueOps;

    @PostConstruct
    private void init() {
        valueOps = template.opsForValue();
    }

    public void save(final ProcessData processData) {
        save(processData, WAIT);
    }

    public void save(final ProcessData processData, StatusEnum status) {
        String keyName = String.format(KEY_NAME, processData.getName(), processData.getSequence());
        String keyStatus = String.format(KEY_STATUS, processData.getName(), processData.getSequence());
        valueOps.set(keyName, processData.getName());
        valueOps.set(keyStatus, status);
        defineFirstSequence(processData.getSequence());
    }

    public List<ProcessData> findSequence(final Integer sequence) {
        String key = String.format(KEY_NAME, ALL, sequence);
        List<String> processors = (List)valueOps.get(key);
        return processors.stream().map(name -> new ProcessData(sequence, name)).collect(toList());
    }

    public List<ProcessData> findPreviousSequence(final Integer sequence) {
        return findSequence(sequence - 1);
    }

    public List<ProcessData> findPosteriorSequence(final Integer sequence) {
        return findSequence(sequence + 1);
    }

    public Boolean isReady(final ProcessData processData) {
        String keyStatus = String.format(KEY_STATUS,  processData.getName(), processData.getSequence());
        StatusEnum status = (StatusEnum) valueOps.get(keyStatus);
        return SUCESS.name().equals(status);
    }

    public Integer getFirstSequence() {
        return (Integer) valueOps.get(KEY_FIRST_SEQUENCE);
    }

    private void defineFirstSequence(final Integer sequence) {
        Integer savedFirstSequence = (Integer) valueOps.get(KEY_FIRST_SEQUENCE);
        if(isNull(savedFirstSequence) || savedFirstSequence > sequence) {
            valueOps.set(KEY_FIRST_SEQUENCE, sequence);
        }
    }
}
