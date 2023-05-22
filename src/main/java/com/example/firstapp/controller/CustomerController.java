package com.example.firstapp.controller;

import com.example.firstapp.configuration.Customer;
import com.example.firstapp.configuration.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping("/api/customers")
    public Iterable<Customer> findAll(){
        return customerRepository.findAll();
    }
}
