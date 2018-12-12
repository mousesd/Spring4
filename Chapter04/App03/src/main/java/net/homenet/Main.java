package net.homenet;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

@SuppressWarnings("Duplicates")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BasicDataSource dataSource = (BasicDataSource) context.getBean(DataSource.class);

        System.out.println("DriverName: " + dataSource.getDriverClassName());
        System.out.println("url: " + dataSource.getUrl());
        System.out.println("username: " + dataSource.getUsername());
        System.out.println("password: " + dataSource.getPassword());
        System.out.println("maxPoolSize: " + dataSource.getMaxActive());
    }
}
