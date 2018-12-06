package net.homenet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements MessageService {
    @Value("#{messageProperties.message}")
    private String message;

    @Override
    public String getMessage() {
        return message;
    }
}
