package com.hq.springboot01.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class MyWebConfigureAdpter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/login").loginProcessingUrl("/toLogin").defaultSuccessUrl("/main",true).
                and().


        authorizeRequests()
                .antMatchers("/css/**","/fonts/**","/images/**","/js/**").permitAll()
                .antMatchers("/login").permitAll()
             .anyRequest().authenticated();
        http.csrf().disable();
    }
}
