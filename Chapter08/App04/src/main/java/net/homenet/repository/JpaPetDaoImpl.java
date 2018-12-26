package net.homenet.repository;

import net.homenet.domain.Pet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaPetDaoImpl implements PetDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pet findById(Integer petId) {
        return entityManager.find(Pet.class, petId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Pet> findAll() {
        return entityManager.createQuery("FROM Pet").getResultList();
    }
}
