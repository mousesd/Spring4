package net.homenet.repository;

import net.homenet.domain.Pet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernatePetDaoImpl implements PetDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Pet findById(Integer petId) {
        Session session = sessionFactory.getCurrentSession();
        return (Pet) session.get(Pet.class, petId);
    }

    @Override
    public List<Pet> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Pet").list();
    }
}
