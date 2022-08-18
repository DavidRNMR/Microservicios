package com.optimissa.BookShelfApi.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.optimissa.BookShelfApi.data.providers.impl.dto.error.DTOSerializerModifier;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class ObjectMapperService {

    private DTOSerializerModifier dtoModifier;

    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper()
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule())
                .registerModule(new SimpleModule()
                        .setSerializerModifier(dtoModifier)
                )
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

}
