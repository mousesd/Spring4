package net.homenet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ProductService productService = context.getBean(ProductService.class);
        productService.addProduct(new Product("Book", 100));
        Product product = productService.findProduct("Book");
        System.out.println(product);
    }
}
