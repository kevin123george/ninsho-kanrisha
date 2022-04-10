package com.hatake.ninshokanrisha.controllers;


import com.hatake.ninshokanrisha.models.Address;
import com.hatake.ninshokanrisha.models.Customer;
import com.hatake.ninshokanrisha.repository.AddressRepo;
import com.hatake.ninshokanrisha.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private AddressRepo addressRepo;

    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok(customerRepo.findById(id));
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer){
        try {
            return new ResponseEntity(customerRepo.save(customer), HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addCustomerAddress")
    public ResponseEntity<Address> addCustomerAddress(@Valid @RequestBody Address address){
        try {
            return new ResponseEntity(addressRepo.save(address), HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
