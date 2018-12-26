package net.homenet;

import net.homenet.domain.Pet;
import net.homenet.repository.PetDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");

        PlatformTransactionManager transactionManager = context.getBean(PlatformTransactionManager.class);
        TransactionStatus status = transactionManager.getTransaction(null);

        PetDao petDao = context.getBean(PetDao.class);
        List<Pet> pets = petDao.findAll();
        System.out.println(pets);

        Pet pet = petDao.findById(12);
        System.out.println(pet);

        transactionManager.commit(status);
    }
}
