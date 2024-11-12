package com.anshul.LoginAPI.service;

import com.anshul.LoginAPI.dto.CustomerRequest;
import com.anshul.LoginAPI.entity.Customer;
import com.anshul.LoginAPI.repo.CustomerRepo;
import com.anshul.LoginAPI.mapper.CustomerMapper;
import com.anshul.LoginAPI.dto.LoginRequest;

import com.anshul.LoginAPI.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public String loginchecking(LoginRequest  req){
        Customer customer=rep.findByEmail(req.email());
        if(customer==null){ return "Invalid email";}
        else{
            if(customer.getPassword().equals(req.password())){return "Login Successfull";}
            else return "Invalid password";
        }
    }




}