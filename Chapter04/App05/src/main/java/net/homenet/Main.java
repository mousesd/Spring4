package net.homenet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;

import javax.sql.DataSource;

@SuppressWarnings("Duplicates")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AbstractDriverBasedDataSource dataSource = (AbstractDriverBasedDataSource) context.getBean(DataSource.class);

        System.out.println("url: " + dataSource.getUrl());
        System.out.println("username: " + dataSource.getUsername());
        System.out.println("password: " + dataSource.getPassword());
    }
}
