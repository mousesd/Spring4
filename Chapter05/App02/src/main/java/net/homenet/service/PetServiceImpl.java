package net.homenet.service;

import net.homenet.domain.Pet;
import net.homenet.repository.PetDao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class PetServiceImpl implements PetService {
    private final PetDao petDao;

    public PetServiceImpl(PetDao petDao) {
        this.petDao = petDao;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED
        , timeout = 10
        , rollbackFor = BusinessException.class)
    public int updatePet(Pet pet) {
        return petDao.updatePet(pet);
    }

    @Override
    @Transactional(readOnly = true)
    public Pet findByPetId(int petId) {
        return petDao.findByPetId(petId);
    }
}
