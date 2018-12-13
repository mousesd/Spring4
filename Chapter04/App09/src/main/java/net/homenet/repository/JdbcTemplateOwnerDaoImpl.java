package net.homenet.repository;

import net.homenet.domain.Owner;
import net.homenet.domain.Pet;
import org.springframework.jdbc.core.JdbcTemplate;

@SuppressWarnings({ "SqlDialectInspection", "SqlNoDataSourceInspection" })
public class JdbcTemplateOwnerDaoImpl implements OwnerDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateOwnerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getOwnerCount() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM OWNER", Integer.class);
    }

    @Override
    public Owner getOwner(String ownerName) {
        return jdbcTemplate.query("SELECT * FROM OWNER A " +
                "INNER JOIN PET B ON B.OWNER_NAME = A.OWNER_NAME " +
                "WHERE A.OWNER_NAME = ?"
            , rs -> {
                if (!rs.next()) {
                    return null;
                }

                Owner owner = new Owner();
                owner.setOwnerName(rs.getString("OWNER_NAME"));
                do {
                    Pet pet = new Pet();
                    pet.setPetId(rs.getInt("PET_ID"));
                    pet.setPetName(rs.getString("PET_NAME"));
                    pet.setOwnerName(rs.getString("OWNER_NAME"));
                    pet.setPrice((Integer) rs.getObject("PRICE"));
                    pet.setBirthDate(rs.getDate("BIRTH_dATE"));
                    owner.getPets().add(pet);
                } while (rs.next());
                return owner;
            }, ownerName);
    }
}
