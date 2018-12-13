package net.homenet;

import net.homenet.repository.JdbcTemplateOwnerDaoImpl;
import net.homenet.repository.JdbcTemplatePetDaoImpl;
import net.homenet.repository.OwnerDao;
import net.homenet.repository.PetDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class PetConfiguration {
    @Bean
    public DataSource dataSource() {
        //# Bean Xml Configuration 과는 다른 스크립트 파일별로 구분자를 지정할수 없음(내가 모르는건지..)
        //# runInitializeScripts() 메서드를 통해서 해결
        DataSource dataSource = new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("scripts/initializeScript.sql")
            .build();

        runInitializeScripts(dataSource);
        return dataSource;
    }

    private void runInitializeScripts(DataSource dataSource) {
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(new ClassPathResource("scripts/procedure.sql"));
        populator.setSeparator("/");
        populator.execute(dataSource);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public PetDao petDao(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new JdbcTemplatePetDaoImpl(jdbcTemplate, namedParameterJdbcTemplate);
    }

    @Bean
    public OwnerDao ownerDao(JdbcTemplate jdbcTemplate) {
        return new JdbcTemplateOwnerDaoImpl(jdbcTemplate);
    }
}
