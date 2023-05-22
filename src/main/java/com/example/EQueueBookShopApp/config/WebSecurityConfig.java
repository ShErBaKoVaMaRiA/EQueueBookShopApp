package com.example.EQueueBookShopApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/authorization","/registration").permitAll()
                .antMatchers("/myEvents","/viewEvents","/viewEQueue","/myProfile").hasAnyAuthority("Клиент")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/authorization")
                .defaultSuccessUrl("/viewEvents")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf().disable().cors().disable();

    }
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT [E-mail],[Пароль]  FROM [dbo].[List_Users] WHERE [E-mail]=?")
                .authoritiesByUsernameQuery("SELECT u.username, ur.roles FROM user u INNER JOIN user_role ur ON u.id = ur.user_id WHERE u.username=?");
    }

//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.addDialect(new SpringSecurityDialect());
//        return templateEngine;
//    }
}
