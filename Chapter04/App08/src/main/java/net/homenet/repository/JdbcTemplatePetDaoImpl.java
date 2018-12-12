package net.homenet.repository;

import net.homenet.domain.Pet;
import org.hsqldb.Row;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings({ "SqlDialectInspection", "SqlNoDataSourceInspection", "Duplicates" })
public class JdbcTemplatePetDaoImpl implements PetDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplatePetDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getPetCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM PET", Integer.class);
    }

    @Override
    public String getPetName(int petId) {
        return jdbcTemplate.queryForObject("SELECT PET_NAME FROM PET WHERE PET_ID = ?", String.class, petId);
    }

    @Override
    public Date getBirthDate(int petId) {
        return jdbcTemplate.queryForObject("SELECT BIRTH_DATE FROM PET WHERE PET_ID = ?", Date.class, petId);
    }

    @Override
    public Pet getPet(int petId) {
        //# Use a queryForMap()
        //Map<String, Object> pet = jdbcTemplate.queryForMap("SELECT * FROM PET WHERE PET_ID = ?", petId);
        //return new Pet((Integer) pet.get("PET_ID")
        //    , (String) pet.get("PET_NAME")
        //    , (String) pet.get("OWNER_NAME")
        //    , (Integer) pet.get("PRICE")
        //    , (Date) pet.get("BIRTH_DATE"));

        //# Use a queryForObject() with anonymous class
        //return jdbcTemplate.queryForObject("SELECT * FROM PET WHERE PET_ID = ?"
        //    , new RowMapper<Pet>() {
        //        @Override
        //        public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
        //            Pet pet = new Pet();
        //            pet.setPetId(rs.getInt("PET_ID"));
        //            pet.setPetName(rs.getString("PET_NAME"));
        //            pet.setOwnerName(rs.getString("OWNER_NAME"));
        //            pet.setPrice(rs.getInt("PRICE"));
        //            pet.setBirthDate(rs.getDate("BIRTH_DATE"));
        //            return pet;
        //        }
        //    }, petId);

        //# Use a queryForObject() with lambda expression
        //return jdbcTemplate.queryForObject("SELECT * FROM PET WHERE PET_ID = ?"
        //    , (rs, rowNum) -> {
        //        Pet pet = new Pet();
        //        pet.setPetId(rs.getInt("PET_ID"));
        //        pet.setPetName(rs.getString("PET_NAME"));
        //        pet.setOwnerName(rs.getString("OWNER_NAME"));
        //        pet.setPrice(rs.getInt("PRICE"));
        //        pet.setBirthDate(rs.getDate("BIRTH_DATE"));
        //        return pet;
        //    }, petId);

        //# Use a queryForObject() with Concrete class
        return jdbcTemplate.queryForObject("SELECT * FROM PET WHERE PET_ID = ?", new PetRowMapper(), petId);
    }

    @Override
    public List<Pet> getAllPetList() {
        List<Map<String, Object>> petList = jdbcTemplate.queryForList("SELECT * FROM PET");
        return petList.stream()
            .map(row -> new Pet((Integer) row.get("PET_ID")
                , (String) row.get("PET_NAME")
                , (String) row.get("OWNER_NAME")
                , (Integer) row.get("PRICE")
                , (Date) row.get("BIRTH_DATE")))
            .collect(Collectors.toList());
    }

    @SuppressWarnings("Duplicates")
    private class PetRowMapper implements RowMapper<Pet> {
        @Override
        public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
            Pet pet = new Pet();
            pet.setPetId(rs.getInt("PET_ID"));
            pet.setPetName(rs.getString("PET_NAME"));
            pet.setOwnerName(rs.getString("OWNER_NAME"));
            pet.setPrice(rs.getInt("PRICE"));
            pet.setBirthDate(rs.getDate("BIRTH_DATE"));
            return pet;
        }
    }
}
