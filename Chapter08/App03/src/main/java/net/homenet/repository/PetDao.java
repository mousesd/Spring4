package net.homenet.repository;

import net.homenet.domain.Pet;

import java.util.List;

public interface PetDao {
    Pet findById(Integer petId);
    List<Pet> findAll();
}
