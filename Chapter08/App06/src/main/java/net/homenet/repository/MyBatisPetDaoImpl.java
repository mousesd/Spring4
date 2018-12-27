package net.homenet.repository;

import net.homenet.domain.Pet;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisPetDaoImpl implements PetDao {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public Pet findById(Integer petId) {
        return sqlSession.selectOne("net.homenet.repository.PetDao.findById", petId);
    }

    @Override
    public List<Pet> findAll() {
        return sqlSession.selectList("net.homenet.repository.PetDao.findAll");
    }
}
