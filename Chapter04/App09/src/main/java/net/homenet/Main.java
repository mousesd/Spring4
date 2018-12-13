package net.homenet;

import net.homenet.domain.Pet;
import net.homenet.repository.OwnerDao;
import net.homenet.repository.PetDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(PetConfiguration.class);

        PetDao petDao = context.getBean(PetDao.class);
        System.out.println("All pet count=" + petDao.getPetCount());
        System.out.println("PetId=1, PetName=" + petDao.getPetName(1) + ", BirthDate=" + petDao.getBirthDate(1));
        System.out.println(petDao.getPet(1));
        System.out.println(petDao.getAllPetList());
        System.out.println(petDao.getPetList("owner02"));
        System.out.println();

        OwnerDao ownerDao = context.getBean(OwnerDao.class);
        System.out.println("Owner count=" + ownerDao.getOwnerCount());
        System.out.println(ownerDao.getOwner("owner02"));
        System.out.println();

        Pet pet = new Pet(8, "진도개", "owner02", 10000, new Date());
        petDao.addPet(pet);
        System.out.println(petDao.getPet(8));

        pet.setPrice(20000);
        pet.setPetName("진도개1");
        petDao.modifyPet(pet);
        System.out.println(petDao.getPet(8));

        petDao.removePet(8);
        System.out.println("All pet count=" + petDao.getPetCount());
        System.out.println();

        List<Pet> pets = petDao.getAllPetList();
        List<Pet> modifyingPets = new ArrayList<>();
        for (Pet p : pets) {
            p.setPetName("PetName");
            modifyingPets.add(p);
        }

        int affected = petDao.modifyAllPetName(modifyingPets);
        System.out.println("Affected count=" + affected);
        System.out.println(petDao.getAllPetList());
        System.out.println();

        System.out.println("Price=" + petDao.getPrice(1));
    }
}
