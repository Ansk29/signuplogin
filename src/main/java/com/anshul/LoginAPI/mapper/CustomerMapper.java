package com.anshul.LoginAPI.mapper;

import com.anshul.LoginAPI.dto.CustomerRequest;
import com.anshul.LoginAPI.entity.Customer;
import com.anshul.LoginAPI.dto.CustomerResponse;
import org.springframework.stereotype.Component;


import java.sql.ConnectionBuilder;


@Component
public class CustomerMapper {
    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }
}