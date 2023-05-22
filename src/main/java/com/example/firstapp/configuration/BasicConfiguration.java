package com.example.firstapp.configuration;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Stream;

@Configuration
public class BasicConfiguration {

    @Bean
    ApplicationListener<ApplicationReadyEvent> basicApplicationListner(CustomerRepository customerRepository){
        List<Customer> customers = List.of(
                new Customer(null, "John", "john@mail.com"),
                new Customer(null, "Dennis", "dennis@mail.com")
        );
        return event -> customerRepository.saveAll(customers);

    }
}
