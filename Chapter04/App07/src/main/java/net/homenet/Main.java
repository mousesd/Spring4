package net.homenet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AccountConfiguration.class);

        AccountDao accountDao = context.getBean(AccountDao.class);
        System.out.println("Balance1= " + accountDao.getBalance("ACCOUNT01"));

        Account account = new Account("ACCOUNT01", 200);
        accountDao.setBalance(account);
        System.out.println("Balance2= " + accountDao.getBalance("ACCOUNT01"));
    }
}
