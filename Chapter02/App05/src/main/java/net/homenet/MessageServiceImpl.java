package net.homenet;

public class MessageServiceImpl implements MessageService {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
