package net.homenet.repository;

import net.homenet.domain.Pet;
import net.homenet.service.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings({ "SqlDialectInspection", "SqlNoDataSourceInspection", "Duplicates" })
@Repository
public class PetDaoImpl implements PetDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PetDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int updatePet(Pet pet) {
        return jdbcTemplate.update("UPDATE PET " +
                "SET PET_NAME = ?, OWNER_NAME = ?, PRICE = ?, BIRTH_DATE = ? " +
                "WHERE PET_ID = ?"
            , pet.getPetName()
            , pet.getOwnerName()
            , pet.getPrice()
            , pet.getBirthDate()
            , pet.getPetId());
    }

    @Override
    public Pet findByPetId(Integer petId) {
        return jdbcTemplate.queryForObject("SELECT * FROM PET WHERE PET_ID = ?"
            , (rs, rowNum) -> {
                Pet pet = new Pet();
                pet.setPetId(rs.getInt("PET_ID"));
                pet.setPetName(rs.getString("PET_NAME"));
                pet.setOwnerName(rs.getString("OWNER_NAME"));
                pet.setPrice((Integer) rs.getObject("PRICE"));
                pet.setBirthDate(rs.getDate("BIRTH_DATE"));
                return pet;
            }, petId);
    }
}
