package com.ravi.sampleapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.sampleapp.dao.CustomerRepository;
import com.ravi.sampleapp.models.Customer;

@Configuration
@EnableAutoConfiguration
@RestController
public class CustomerController {

	@Autowired 
	CustomerRepository repository;

	@RequestMapping(value="/customer", method=RequestMethod.GET)
    public Customer getCustomer() {
        // fetch an individual customer by ID
        Customer customer = repository.findOne(1L);
        System.out.println(customer);
        System.out.println();
        return customer;
    }

    @RequestMapping("/customer/{name}")
    public List<Customer> getCustomerByName(@PathVariable String name) {
        // fetch a list of customers by name
        return repository.findByName(name);
    }
    
    @RequestMapping(value="/customer", method=RequestMethod.POST)
    public Customer updateCustomer(@RequestBody Customer customer) {
    	System.out.println("Updating customer ...."+customer.getName());
        return repository.save(customer);
        
    }
    
    @RequestMapping(value="/customer", method=RequestMethod.DELETE)
    public void deleteCustomer(@RequestBody Customer customer) {
    	System.out.println("Deleting customer ....");
        repository.delete(customer);
    }

    @RequestMapping ("/customers")
    public  @ResponseBody Iterable<Customer> getCustomers() {
        // fetch an individual customer by ID
        
        Iterable<Customer> customers = repository.findAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        return customers;
    }
	
}