package com.azsnowsports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.azsnowsports.business.UserBusinessService;

/**
 * @author Zac Almas and Austin Driver
 * 
 * Configuration class used by spring security
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    /**
     * Class variable used for encoding passwords
     */
    @Autowired
    @Lazy
    PasswordEncoder passwordEncoder;
    
    /**
     * Class variable used for accessing the user business service
     */
    @Autowired
    UserBusinessService service;
    
    /**
     * Bean used for getting the password encoder
     * 
     * @return Returns a new password encoder
     */
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    /**
     * Configuration method used by spring security to allow permissions
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/", "/images/**", "/service/**", "/register/", "/register/doRegister", "/public/", "/assets/**", "/styles/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .defaultSuccessUrl("/timeline/", true)
                .and()
            .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll()
                .logoutSuccessUrl("/");
    }
    
    /**
     * Autowired configuration method used by spring security for authentication
     */
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(service).passwordEncoder(passwordEncoder);
        
    }
}