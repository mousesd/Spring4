package net.homenet;

import net.homenet.domain.Pet;
import net.homenet.service.PetService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        PetService petService = context.getBean(PetService.class);
        Pet pet = petService.findByPetId(1);

        pet.setPetName("PetName");
        petService.updatePet(pet);
        System.out.println(petService.findByPetId(1));
    }
}
