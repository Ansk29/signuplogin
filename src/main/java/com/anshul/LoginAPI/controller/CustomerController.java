package com.anshul.LoginAPI.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import com.anshul.LoginAPI.dto.CustomerRequest;
import com.anshul.LoginAPI.service.CustomerService;
import com.anshul.LoginAPI.dto.LoginRequest;
import org.springframework.security.core.parameters.P;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody @Valid CustomerRequest req) {
        return ResponseEntity.ok(customerService.creating(req));
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest req){
        return ResponseEntity.ok(customerService.loginchecking(req));
    }

}


