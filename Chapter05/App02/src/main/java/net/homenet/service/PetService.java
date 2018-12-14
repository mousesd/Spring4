package net.homenet.service;

import net.homenet.domain.Pet;

public interface PetService {
    int updatePet(Pet pet);
    Pet findByPetId(int petId);
}
