package net.homenet;

import net.homenet.repository.PetDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        PetDao petDao = context.getBean(PetDao.class);
        System.out.println("All pet count=" + petDao.getPetCount());
        System.out.println("PetId=1, PetName=" + petDao.getPetName(1) + ", BirthDate=" + petDao.getBirthDate(1));
        System.out.println(petDao.getPet(1));
        System.out.println(petDao.getAllPetList());
    }
}
