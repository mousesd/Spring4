package net.homenet.repository;

import net.homenet.domain.Pet;

public interface PetDao {
    int updatePet(Pet pet);
    Pet findByPetId(Integer petId);
}
