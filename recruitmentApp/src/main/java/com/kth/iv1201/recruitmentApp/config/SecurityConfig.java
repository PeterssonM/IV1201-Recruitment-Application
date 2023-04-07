package com.kth.iv1201.recruitmentApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kth.iv1201.recruitmentApp.application.PersonService;


/**
 * This is the configuration class for Spring Security. Extends the WebSecurityConfigurerAdapter
 * class and overrides some of its methods to configure authentication and
 * authorization settings for the application. 
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private PersonService personService;

    /**
     * Defines the bean for the password encoder used for encoding user passwords.
     * @return a new instance of the BCryptPasswordEncoder class.
     */
    @Bean
    public PasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures authentication for the application by using a DAO authentication provider.
     * 
     * @param auth the AuthenticationManagerBuilder object to configure.
     * @throws Exception if an error occurs while configuring authentication.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    /**
     * Defines the bean for the DAO authentication provider used for authentication.
     * @return a new instance of the DaoAuthenticationProvider class.
     */
    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(personService);
        return daoAuthenticationProvider;
    }

    /**
     * This method configures web security settings for the application. Specifies which 
     * resources should be ignored by Spring Security.
     * @param web the WebSecurity object to configure.
     * @throws Exception if an error occurs while configuring web security.
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .antMatchers("/css/**")
            .antMatchers("/fragments/**")
            .antMatchers("/image/**");
    }
    
    /**
     * Configures the HTTP security settings for the application. Specifies 
     * which requests should be permitted and which should require authorization.
     * @param http the HttpSecurity object to configure.
     * @throws Exception if an error occurs while configuring HTTP security.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/", true)
                .permitAll()
                .and()
            .logout()
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
            .authorizeRequests()
                .antMatchers("/", "/register").permitAll()
                .antMatchers("/application").hasAuthority("applicant")
                .antMatchers("/viewApplications").hasAuthority("recruiter")
                .anyRequest().authenticated();
                
    }
}
