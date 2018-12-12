package net.homenet.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateOwnerDaoImpl implements OwnerDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateOwnerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getPetCount(String ownerName) {
        return 0;
    }
}
