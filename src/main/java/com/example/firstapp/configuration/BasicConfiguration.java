package com.example.firstapp.configuration;

import com.example.firstapp.model.Customer;
import com.example.firstapp.repository.CustomerRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

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
