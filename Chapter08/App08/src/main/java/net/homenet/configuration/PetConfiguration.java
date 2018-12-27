package net.homenet.configuration;

import net.homenet.domain.Pet;
import net.homenet.repository.PetDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@SuppressWarnings("Duplicates")
@Configuration
@ComponentScan("net.homenet")
@MapperScan("net.homenet.repository")
public class PetConfiguration {
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.HSQL)
            .addScript("scripts/table.sql")
            .addScript("scripts/data.sql")
            .build();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        sqlSessionFactory.setMapperLocations(
            new Resource[]{ new ClassPathResource("net/homenet/mapper/Pet.xml") }

            // 아래 코드를 사용하는 Pet.xml 파일을 찾지 못하는 예외가 발생
            // new Resource[]{ new ClassPathResource("net/homenet/mapper/*.xml") }
        );
        return sqlSessionFactory;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSession sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    //# 하나씩 등록할 경우
    //@Bean
    //public PetDao petDao(SqlSessionFactory sqlSessionFactory) {
    //    SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
    //    return template.getMapper(PetDao.class);
    //}
}
