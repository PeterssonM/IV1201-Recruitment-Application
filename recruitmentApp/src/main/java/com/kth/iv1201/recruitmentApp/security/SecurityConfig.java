package com.kth.iv1201.recruitmentApp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    System.out.println("\n \n 66666666666666666666666??????????????? \n \n ");
      return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("\n \n 555555555555555555??????????????? \n \n ");
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

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
    

   /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/register").permitAll() // allow access to /register endpoint without authentication
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll() // set custom login page at /login and allow access to it without authentication
                .and()
                .httpBasic();
    }*/
    
}
