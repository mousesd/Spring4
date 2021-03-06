package net.homenet.configuation;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/top.jsp").permitAll()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
            .and().formLogin()
                .defaultSuccessUrl("/top.jsp")
            .and().logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/top.jsp")
            .and().csrf()
                .disable();
    }

    //# InMemory authentication
    //@Override
    //protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //    auth.inMemoryAuthentication()
    //        .withUser("user")
    //            .password("userpassword")
    //            .authorities("ROLE_USER")
    //        .and()
    //        .withUser("admin")
    //            .password("adminpassword")
    //        .authorities("ROLE_ADMIN");
    //}

    //# Database authentication
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .setName("authentication")
            .addScript("classpath:/META-INF/db/ddl.sql")
            .addScript("classpath:/META-INF/db/dml.sql")
            .build();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource())
            .usersByUsernameQuery("SELECT login_id, password, true "
                + "FROM t_user "
                + "WHERE login_id = ?")
            .authoritiesByUsernameQuery("SELECT login_id, role_name "
                + "FROM t_role "
                + "     INNER JOIN t_user_role ON t_user_role.role_id = t_role.id "
                + "     INNER JOIN t_user ON t_user.id = t_user_role.user_id "
                + "WHERE login_id = ?");
    }
}
