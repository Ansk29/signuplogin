package com.anshul.LoginAPI.service;

import com.anshul.LoginAPI.dto.CustomerRequest;
import com.anshul.LoginAPI.dto.CustomerResponse;
import com.anshul.LoginAPI.dto.LoginRequest;
import com.anshul.LoginAPI.entity.Customer;
import com.anshul.LoginAPI.exception.CustomerNotFound;
import com.anshul.LoginAPI.mapper.CustomerMapper;
import com.anshul.LoginAPI.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepo rep;
    private final CustomerMapper mapper;

    public String creating(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        rep.save(customer);
        return "created";
    }

    public Customer getCustomer(String email) {
        return rep.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFound(
                        format("Cannot find Customer:: No customer found with the provided email:: %s", email)
                ));
    }

    public CustomerResponse retrieveCustomer(String email) {
        Customer customer = getCustomer(email);
        return mapper.toResponse(customer);
    }

    public String loginchecking(LoginRequest req) {
        Customer customer = rep.findByEmail(req.email())
                .orElseThrow(() -> new CustomerNotFound("Not found"));

        if (customer.getPassword().equals(req.password())) {
            return "Login Successful";
        } else {
            return "Invalid password";
        }
    }

}
