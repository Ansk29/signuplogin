package com.anshul.LoginAPI.mapper;

import com.anshul.LoginAPI.dto.CustomerRequest;
import com.anshul.LoginAPI.entity.Customer;
import com.anshul.LoginAPI.dto.CustomerResponse;
import org.springframework.stereotype.Service;




@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .address(request.address()) // Add address
                .city(request.city())       // Add city
                .pincode(request.pincode()) // Add pincode
                .build();
    }

    public CustomerResponse toCustomerResponse(Customer customer) {
        return new CustomerResponse(customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }
}
