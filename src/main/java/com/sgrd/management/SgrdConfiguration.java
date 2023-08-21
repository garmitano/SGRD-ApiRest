package com.sgrd.management;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SgrdConfiguration {
    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
