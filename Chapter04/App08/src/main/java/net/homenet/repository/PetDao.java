package net.homenet.repository;

import net.homenet.domain.Pet;

import java.util.Date;
import java.util.List;

public interface PetDao {
    int getPetCount();
    String getPetName(int petId);
    Date getBirthDate(int petId);
    Pet getPet(int petId);
    List<Pet> getAllPetList();
}
