package net.homenet.service;

import net.homenet.domain.Pet;
import net.homenet.repository.PetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class PetServiceImpl implements PetService {
    private final PetDao petDao;
    private final PlatformTransactionManager transactionManager;

    @Autowired
    public PetServiceImpl(PetDao petDao, PlatformTransactionManager transactionManager) {
        this.petDao = petDao;
        this.transactionManager = transactionManager;
    }

    @Override
    public int updatePet(Pet pet) {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        definition.setTimeout(10);
        definition.setReadOnly(false);

        TransactionStatus status = transactionManager.getTransaction(definition);
        try {
            int affected = petDao.updatePet(pet);
            transactionManager.commit(status);
            return affected;
        } catch (RuntimeException e) {
            transactionManager.rollback(status);
            throw e;
        }
    }

    @Override
    public Pet findByPetId(int petId) {
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setReadOnly(true);

        TransactionStatus status = transactionManager.getTransaction(definition);
        try {
            Pet pet = petDao.findByPetId(petId);
            transactionManager.commit(status);
            return pet;
        } catch (RuntimeException e) {
            transactionManager.rollback(status);
            throw e;
        }
    }
}
