package net.homenet.service;

import net.homenet.domain.Pet;
import net.homenet.repository.PetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@SuppressWarnings("Duplicates")
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
        //# Use a TransactionManager class
        //DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        //definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        //definition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        //definition.setTimeout(10);
        //definition.setReadOnly(false);
        //
        //TransactionStatus status = transactionManager.getTransaction(definition);
        //try {
        //    int affected = petDao.updatePet(pet);
        //    transactionManager.commit(status);
        //    return affected;
        //} catch (RuntimeException e) {
        //    transactionManager.rollback(status);
        //    throw e;
        //}

        //# Use a TransactionTemplate
        TransactionTemplate template = new TransactionTemplate(transactionManager);
        template.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        template.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        template.setTimeout(10);
        template.setReadOnly(false);

        //# Anonymous class
        //return template.execute(new TransactionCallback<Integer>() {
        //    @Override
        //    public Integer doInTransaction(TransactionStatus status) {
        //        return petDao.updatePet(pet);
        //    }
        //});

        return template.execute(status -> petDao.updatePet(pet));
    }

    @Override
    public Pet findByPetId(int petId) {
        //# Use a TransactionManager class
        //DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        //definition.setReadOnly(true);
        //
        //TransactionStatus status = transactionManager.getTransaction(definition);
        //try {
        //    Pet pet = petDao.findByPetId(petId);
        //    transactionManager.commit(status);
        //    return pet;
        //} catch (RuntimeException e) {
        //    transactionManager.rollback(status);
        //    throw e;
        //}

        //# Use a TransactionTemplate
        TransactionTemplate template = new TransactionTemplate(transactionManager);
        template.setReadOnly(true);

        //# Anonymous class
        //return template.execute(new TransactionCallback<Pet>() {
        //    @Override
        //    public Pet doInTransaction(TransactionStatus status) {
        //        return petDao.findByPetId(petId);
        //    }
        //});

        return template.execute(status -> petDao.findByPetId(petId));
    }
}
