package net.homenet.batch.step;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("itemProcessor")
public class EntryItemProcessor implements ItemProcessor<String, String> {
    @Override
    public String process(String message) throws Exception {
        return message + " !!";
    }
}
