package net.homenet.repository;

import net.homenet.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SuppressWarnings({ "SqlDialectInspection", "SqlNoDataSourceInspection", "Duplicates" })
@Repository
public class JdbcTemplatePetDaoImpl implements PetDao {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //public JdbcTemplatePetDaoImpl(JdbcTemplate jdbcTemplate) {
    //    this.jdbcTemplate = jdbcTemplate;
    //}

    @Autowired
    public JdbcTemplatePetDaoImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
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
        //# Use a queryForList()
        //List<Map<String, Object>> petList = jdbcTemplate.queryForList("SELECT * FROM PET");
        //return petList.stream()
        //    .map(row -> new Pet((Integer) row.get("PET_ID")
        //        , (String) row.get("PET_NAME")
        //        , (String) row.get("OWNER_NAME")
        //        , (Integer) row.get("PRICE")
        //        , (Date) row.get("BIRTH_DATE")))
        //    .collect(Collectors.toList());

        //# Use a query() with anonymous
        //return jdbcTemplate.query("SELECT * FROM PET"
        //    , new RowMapper<Pet>() {
        //        @Override
        //        public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
        //            Pet pet = new Pet();
        //            pet.setPetId(rs.getInt("PET_ID"));
        //            pet.setPetName(rs.getString("PET_NAME"));
        //            pet.setOwnerName(rs.getString("OWNER_NAME"));
        //            pet.setPrice((Integer) rs.getObject("PRICE"));
        //            pet.setBirthDate(rs.getDate("BIRTH_DATE"));
        //            return pet;
        //        }
        //    });

        //# Use a query() with lambda expression
        //return jdbcTemplate.query("SELECT * FROM PET"
        //    , (rs, rowNum) -> {
        //        Pet pet = new Pet();
        //        pet.setPetId(rs.getInt("PET_ID"));
        //        pet.setPetName(rs.getString("PET_NAME"));
        //        pet.setOwnerName(rs.getString("OWNER_NAME"));
        //        pet.setPrice((Integer) rs.getObject("PRICE"));
        //        pet.setBirthDate(rs.getDate("BIRTH_DATE"));
        //        return pet;
        //    });

        //# Use a query() with Concrete class
        //return jdbcTemplate.query("SELECT * FROM PET", new PetRowMapper());

        //# Use a query() with BeanPropertyRowMapper class
        return jdbcTemplate.query("SELECT * FROM PET", new BeanPropertyRowMapper<>(Pet.class));
    }

    @Override
    public List<Pet> getPetList(String ownerName) {
        return jdbcTemplate.query("SELECT * FROM PET WHERE OWNER_NAME = ?"
            , new BeanPropertyRowMapper<>(Pet.class)
            , ownerName);
    }

    @Override
    public int addPet(Pet pet) {
        //# Use a JdbcTemplate
        //return jdbcTemplate.update("INSERT INTO PET (PET_ID, PET_NAME, OWNER_NAME, PRICE, BIRTH_DATE) " +
        //        "VALUES (?, ?, ?, ?, ?)"
        //    , pet.getPetId(), pet.getPetName(), pet.getOwnerName(), pet.getPrice(), pet.getBirthDate());

        //# Use a NamedParameterJdbcTemplate & MapSqlParameterSource
        //return namedParameterJdbcTemplate.update("INSERT INTO PET (PET_ID, PET_NAME, OWNER_NAME, PRICE, BIRTH_DATE) " +
        //        "VALUES (:PET_ID, :PET_NAME, :OWNER_NAME, :PRICE, :BIRTH_DATE)"
        //    , new MapSqlParameterSource()
        //        .addValue("PET_ID", pet.getPetId())
        //        .addValue("PET_NAME", pet.getPetName())
        //        .addValue("OWNER_NAME", pet.getOwnerName())
        //        .addValue("PRICE", pet.getPrice())
        //        .addValue("BIRTH_DATE", pet.getBirthDate()));

        //# Use a NamedParameterJdbcTemplate & BeanPropertySqlParameterSource
        return namedParameterJdbcTemplate.update("INSERT INTO PET (PET_ID, PET_NAME, OWNER_NAME, PRICE, BIRTH_DATE) " +
                "VALUES (:petId, :petName, :ownerName, :price, :birthDate)"
            , new BeanPropertySqlParameterSource(pet));
    }

    @Override
    public int modifyPet(Pet pet) {
        return jdbcTemplate.update("UPDATE PET SET PET_NAME = ?, OWNER_NAME = ?, PRICE = ?, BIRTH_DATE = ? " +
                "WHERE PET_ID = ?"
            , pet.getPetName(), pet.getOwnerName(), pet.getPrice(), pet.getBirthDate(), pet.getPetId());
    }

    @Override
    public void removePet(int petId) {
        jdbcTemplate.update("DELETE FROM PET WHERE PET_ID = ?", petId);
    }

    @Override
    public int modifyAllPetName(List<Pet> pets) {
        //# Use a JdbcTemplate & BatchPreparedStatementSetter
        //int[] affected = jdbcTemplate.batchUpdate("UPDATE PET SET PET_NAME = ? WHERE PET_ID = ?"
        //    , new BatchPreparedStatementSetter() {
        //        @Override
        //        public void setValues(PreparedStatement ps, int i) throws SQLException {
        //            ps.setString(1, pets.get(i).getPetName());
        //            ps.setInt(2, pets.get(i).getPetId());
        //        }
        //
        //        @Override
        //        public int getBatchSize() {
        //            return pets.size();
        //        }
        //    });
        //
        //return Arrays.stream(affected).sum();

        //# Use a NamedParameterJdbcTemplate & SqlParameterSource, SqlParameterSourceUtils
        int[] affected = namedParameterJdbcTemplate.batchUpdate("UPDATE PET SET PET_NAME = :petName WHERE PET_ID = :petId"
            , SqlParameterSourceUtils.createBatch(pets.toArray()));

        return Arrays.stream(affected).sum();
    }

    @Override
    public int getPrice(int petId) {
        SimpleJdbcCall call = new SimpleJdbcCall(jdbcTemplate)
            .withProcedureName("CALC_PET_PRICE")
            .withoutProcedureColumnMetaDataAccess()
            .declareParameters(new SqlParameter("IN_PET_ID", Types.INTEGER)
                , new SqlOutParameter("OUT_PRICE", Types.INTEGER));

        Map<String, Object> out = call.execute(new MapSqlParameterSource().addValue("IN_PET_ID", petId));
        return (Integer) out.get("OUT_PRICE");
    }

    @SuppressWarnings("Duplicates")
    private class PetRowMapper implements RowMapper<Pet> {
        @Override
        public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
            Pet pet = new Pet();
            pet.setPetId(rs.getInt("PET_ID"));
            pet.setPetName(rs.getString("PET_NAME"));
            pet.setOwnerName(rs.getString("OWNER_NAME"));
            pet.setPrice((Integer) rs.getObject("PRICE"));
            pet.setBirthDate(rs.getDate("BIRTH_DATE"));
            return pet;
        }
    }
}
