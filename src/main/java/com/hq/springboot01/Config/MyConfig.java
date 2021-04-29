package com.hq.springboot01.Config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Import(BCryptPasswordEncoder.class)
public class MyConfig {

}
