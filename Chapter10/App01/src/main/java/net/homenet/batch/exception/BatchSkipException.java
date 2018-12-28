package net.homenet.batch.exception;

public class BatchSkipException extends RuntimeException {
    public BatchSkipException(String message) {
        super(message);
    }
}
