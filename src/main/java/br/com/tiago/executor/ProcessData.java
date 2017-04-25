package br.com.tiago.executor;

import static java.util.Objects.isNull;

import br.com.tiago.annotation.Processor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProcessData {

    private int sequence;
    private String name;

    public ProcessData(final Executor executor) {
        Processor annotation = executor.getClass().getAnnotation(Processor.class);
        if(isNull(annotation)) {
            throw new RuntimeException("Invalid executor.");
        }
        sequence = annotation.sequence();
        name = annotation.value();
    }

}
