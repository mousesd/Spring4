package net.homenet.repository;

import net.homenet.domain.Pet;

import java.util.Date;
import java.util.List;

@SuppressWarnings("UnusedReturnValue")
public interface PetDao {
    int getPetCount();
    String getPetName(int petId);
    Date getBirthDate(int petId);
    Pet getPet(int petId);
    List<Pet> getAllPetList();
    List<Pet> getPetList(String ownerName);
    int addPet(Pet pet);
    int modifyPet(Pet pet);
    void removePet(int petId);
    int modifyAllPetName(List<Pet> pets);
    int getPrice(int petId);
}
