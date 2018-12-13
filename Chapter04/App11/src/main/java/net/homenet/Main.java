package net.homenet;

import net.homenet.dao.PetDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        PetDao petDao = context.getBean(PetDao.class);
        System.out.println(petDao.findByPetName("나비"));
        System.out.println(petDao.findByPetNameAndPriceLessThanEqual("나비", 10000));
        System.out.println(petDao.findByOwnerName("홍길동"));

        //# 아래 예외가 발생
        //# - Caused by: javax.persistence.TransactionRequiredException: Executing an update/delete query
        //int affected = petDao.updatePetPrice(1000000, "발라리");
        //System.out.println("Affected row: " + affected + ", "  + petDao.findByPetName("발라리"));

        petDao.echo();
    }
}
