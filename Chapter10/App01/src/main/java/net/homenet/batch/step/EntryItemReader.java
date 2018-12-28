package net.homenet.batch.step;

import net.homenet.batch.exception.BatchSkipException;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

@Component("itemReader")
public class EntryItemReader implements ItemReader<String> {
    private final String[] INPUT_STRING = { "Hello, Spring Batch", "mousesd", "Hi", "mousesd", null };
    private int index = 0;

    @Override
    public String read() throws Exception {
        String message = INPUT_STRING[index++];
        if (message == null) {
            return null;
        }

        if (message.equals("mousesd")) {
            throw new BatchSkipException("Invalid data: " + message);
        }
        return message;
    }
}
