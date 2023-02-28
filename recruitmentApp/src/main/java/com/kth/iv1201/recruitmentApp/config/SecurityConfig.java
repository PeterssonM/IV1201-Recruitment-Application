package com.kth.iv1201.recruitmentApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
            .antMatchers("/register","/login","/index").permitAll()
            .and()
            .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/loginSuccess")
            .and()
            .logout().logoutSuccessUrl("/logout");
    }
}
