package net.homenet.configuration;

import net.homenet.repository.PetDao;
import net.homenet.repository.PetDaoImpl;
import net.homenet.service.PetService;
import net.homenet.service.PetServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class PetConfiguration {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("scripts/initializeScript.sql")
            .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

     //# 트랜잭션 관련 Bean Xml 설정을 Java configuration 으로 대체가 불가능?
     //# - https://stackoverflow.com/questions/14068525/javaconfig-replacing-aopadvisor-and-txadvice
     //# - <tx:advice/>, <aop:config/>

    @Bean
    public PetDao petDao(JdbcTemplate jdbcTemplate) {
        return new PetDaoImpl(jdbcTemplate);
    }

    @Bean
    public PetService petService(PetDao petDao) {
        return new PetServiceImpl(petDao);
    }
}
