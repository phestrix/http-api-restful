package ru.phestrix.httpapirestful.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v0.0/customer")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService service){
        customerService = service;
    }

    @GetMapping
    public List<Customer> getStudent(){
        return customerService.getCustomers();
    }
}
