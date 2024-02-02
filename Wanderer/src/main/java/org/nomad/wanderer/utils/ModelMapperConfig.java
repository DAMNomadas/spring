package org.nomad.wanderer.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Esta clase es para configurar el ModelMapper
// @Configuration indica que es una clase de configuracion,
// y @Bean indica que es un bean, es decir, una instancia de la clase ModelMapper
// El bean modelMapper se crea en el método modelMapper()

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}