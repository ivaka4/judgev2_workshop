package com.example.judgev2.workshop.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationBeanConfiguration {

//    @Bean
//    public XmlParser xmlParser(){
//       return new XmlParserImpl();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new Pbkdf2PasswordEncoder();
//    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
