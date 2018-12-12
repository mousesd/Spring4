package net.homenet;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfiguration.class);
        BasicDataSource dataSource = (BasicDataSource) context.getBean(DataSource.class);

        System.out.println("DriverName: " + dataSource.getDriverClassName());
        System.out.println("Url: " + dataSource.getUrl());
        System.out.println("Username: " + dataSource.getUsername());
        System.out.println("Password: " + dataSource.getPassword());
        System.out.println("MaxPoolSize: " + dataSource.getMaxActive());
    }
}
