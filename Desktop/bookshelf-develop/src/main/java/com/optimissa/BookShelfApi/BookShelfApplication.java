package com.optimissa.BookShelfApi;

import com.optimissa.BookShelfApi.data.providers.IUserProvider;
import com.optimissa.BookShelfApi.data.providers.impl.dto.request.UserRequestDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class BookShelfApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookShelfApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(IUserProvider userProvider) {
        return args -> {
            userProvider.register(new UserRequestDTO("carlos@gmail.com","carlos","1234"));
        };

    }


}
