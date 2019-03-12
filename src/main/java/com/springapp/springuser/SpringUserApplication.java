package com.springapp.springuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringUserApplication {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
//    @Bean
//    public JavaMailSender javaMailSender(){
//        return new JavaMailSenderImpl();
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringUserApplication.class, args);
    }

}
