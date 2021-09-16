package com.neoris.support.services;

import com.neoris.support.controllers.CustomerController;
import com.neoris.support.entities.Customer;
import com.neoris.support.entities.TypeCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerService {
    @Autowired
    CustomerController customerController;

    @GetMapping("/types/all")
    public List<TypeCustomer> getAllCustomerTypes(){
        return this.customerController.getAllCustomerTypes();
    }

    @PostMapping("/create/{idTypeCustomer}")
    public Customer createCustomer(@RequestBody Customer customer, @PathVariable Integer idTypeCustomer){
        return this.customerController.createCustomer(customer,idTypeCustomer);
    }

    @GetMapping("/search")
    public Customer getCustomerByDocumentNumber(@RequestParam String document){
        return this.customerController.getCustomerByDocumentNumber(document);
    }
}
