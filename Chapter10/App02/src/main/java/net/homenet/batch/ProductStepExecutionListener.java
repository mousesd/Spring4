package net.homenet.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.stereotype.Component;

@Component
public class ProductStepExecutionListener {
    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("*** Before step: Start time " + stepExecution.getStartTime());
    }

    @AfterStep
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("*** After step: Commit count " + stepExecution.getCommitCount());
        return ExitStatus.COMPLETED;
    }
}
