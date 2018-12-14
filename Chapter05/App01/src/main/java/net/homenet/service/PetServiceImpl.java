package net.homenet.service;

import net.homenet.domain.Pet;
import net.homenet.repository.PetDao;

public class PetServiceImpl implements PetService {
    private final PetDao petDao;

    public PetServiceImpl(PetDao petDao) {
        this.petDao = petDao;
    }

    @Override
    public int updatePet(Pet pet) {
        return petDao.updatePet(pet);
    }

    @Override
    public Pet findByPetId(int petId) {
        return petDao.findByPetId(petId);
    }
}
