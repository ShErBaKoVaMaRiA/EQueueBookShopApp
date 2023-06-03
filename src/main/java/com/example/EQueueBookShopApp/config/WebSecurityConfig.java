package com.example.EQueueBookShopApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
//Класс конфигурации сайта и работой с Spring Security
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers( "/","/css/**", "/login", "/registration").permitAll()
                        .requestMatchers("/", "/css/**", "/myProfile", "/myEvents", "/viewEvents", "/viewEQueue","/**").hasAuthority("Клиент").anyRequest()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/myProfile")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll()).cors().and().csrf().disable();
        return http.build();
    }
@Autowired
private DataSource dataSource;
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT EmailUser, PasswordUser,ID_User FROM table_Users WHERE Role_ID=5 and ConsentPersonalData='Y' and EmailUser=?")
                .authoritiesByUsernameQuery("SELECT u.EmailUser, ur.NameRole FROM table_Users u INNER JOIN Table_Roles ur ON u.Role_ID = ur.ID_Role WHERE Role_ID=5 and ConsentPersonalData='Y' and u.EmailUser=?");
    }
}