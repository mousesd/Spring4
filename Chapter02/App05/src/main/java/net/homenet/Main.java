package net.homenet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MessageService messageService = context.getBean(MessageService.class);
        System.out.println(messageService.getMessage());
    }
}
