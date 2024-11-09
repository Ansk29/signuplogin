package com.anshul.signuplogin.service;

import com.anshul.signuplogin.dto.CustomerRequest;
import com.anshul.signuplogin.dto.LoginRequest;
import com.anshul.signuplogin.entity.Customer;
import com.anshul.signuplogin.mapper.CustomerMapper;
import com.anshul.signuplogin.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        repo.save(customer);
        return "Created";
    }

    public boolean login(String email, String password) {
        Optional<Customer> customer = repo.findByEmailAndPassword(email, password);
        return customer.isPresent();
    }

}
